package com.pc.springboot.controller;

import com.pc.Enum.ExcelModel;
import com.pc.someTest.Employee;
import com.pc.springboot.modela;
import com.pc.springboot.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//@ResponseBody
//@Controller("/test")
@RequestMapping(value = "/test")
@RestController//等于上面两个注解
@Slf4j
public class HelloController {

    @Value("${es.name:mike}")
    private String name;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private Employee e;

    @Bean("getE")
    public Employee getE() {
        Employee e = new Employee();
        e.setAge(1);
        e.setDept("2");
        e.setName("name");
        return e;
    }

    @Autowired
    HelloService helloService;

    //@ResponseBody//可以直接加在类前面，表示这个类下所有的方法返回数据都直接传给浏览器（如果是对象自动转为JSON数据）
    @RequestMapping("/hello")
    public void hello() {
        helloService.helloService();

    }


    @RequestMapping("/test")
    public void testExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        //拿到multipartfile
        String originalFileName = file.getOriginalFilename();
        log.info("收到批量导入付费产品类型接口[{}]", originalFileName);

        //判断后缀名
        if (StringUtils.isNotBlank(originalFileName)) {
            if (!originalFileName.endsWith(".xlsx")) {
                throw new Exception("originalFileName");
            }
        }

        //暂限定大小10M,修改
        if (file.getSize() > 10L*1024*1024) {
            throw new Exception("文件大于10M");
        }

        InputStream in = null;

        try {
            in = file.getInputStream();

            //放到Util中，返回一个List<ExcelModel>
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
            XSSFSheet sheet = xssfWorkbook.getSheet("付费产品");
            int lastRowNum = sheet.getLastRowNum();
            List<ExcelModel> list = Lists.newArrayList();
            ExcelModel em;
            for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {//不看表头行，1开始
                XSSFRow row = sheet.getRow(rowNum);
                if (row == null) {//注意静态检查
                    continue;
                }


                em = new ExcelModel();


                //付费产品名称（必填，10字以内）
                XSSFCell payProduct = row.getCell(0);//必填
                if (payProduct != null) {
                    payProduct.setCellType(CellType.STRING);
                    int length = payProduct.toString().length();
                    if (payProduct.toString().length() > 100) {
                        throw new Exception("payProduct");///////
                    }
                }

                //付费类型（必填。0:单月；1:单季；2:半年；3:一年；4:两年 5:单次）
                XSSFCell priceType = row.getCell(1);//必填
                if (priceType != null) {
                    priceType.setCellType(CellType.STRING);
                    if (Arrays.asList("0", "1", "2", "3", "4", "5").contains(priceType)) {
                        throw new Exception("priceType");///////
                    }
                }

                //支付方式(必填，1：苹果支付；2：话费支付；3：第三方支付)
                XSSFCell deviceType = row.getCell(2);//必填
                if (deviceType != null) {
                    deviceType.setCellType(CellType.STRING);
                    if (Arrays.asList("1", "2", "3").contains(deviceType)) {
                        throw new Exception("deviceType");///////
                    }
                }

                //价格（必填，元）
                XSSFCell productPrice = row.getCell(3);//必填
                if (productPrice != null) {
                    productPrice.setCellType(CellType.STRING);
                    if (productPrice.toString().length() > 10) {
                        throw new Exception("productPrice");///////
                    }
                }

                //付费产品Id（必填）
                XSSFCell productId = row.getCell(4);//必填
                if (productId != null) {
                    productId.setCellType(CellType.STRING);
                    if (productId.toString().length() > 10) {
                        throw new Exception("productId");///////
                    }
                }

                //苹果支付Id（选填，当支付方式为苹果支付时填写）
                XSSFCell appleId = row.getCell(5);//必填
                if ("1".equals(deviceType) && appleId == null) {
                    throw new Exception("appleId");
                } else if (appleId != null) {
                    appleId.setCellType(CellType.STRING);
                    if (appleId.toString().length() > 10) {
                        throw new Exception("appleId");///////
                    }
                }

                //封装对象
                String strTrim;

                if (payProduct != null && !"".equals(strTrim = payProduct.toString().trim())) {
                    em.setPayProduct(strTrim);
                }

                if (priceType != null && !"".equals(strTrim = priceType.toString().trim())) {
                    em.setPriceType(strTrim);
                }

                if (deviceType != null && !"".equals(strTrim = deviceType.toString().trim())) {
                    em.setDeviceType(strTrim);
                }

                if (productPrice != null && !"".equals(strTrim = productPrice.toString().trim())) {
                    try {
                        em.setProductPrice(new BigDecimal(strTrim));
                    } catch (Exception e) {
                        log.info("价格信息错误：{}" + strTrim);
                        throw new Exception("strTrim");
                    }
                }

                if (productId != null && !"".equals(strTrim = productId.toString().trim())) {
                    em.setProductId(strTrim);
                }

                if (appleId != null && !"".equals(strTrim = appleId.toString().trim())) {
                    em.setAppleId(strTrim);
                }

                list.add(em);

            }

            System.out.println(list);
        } catch (IOException ex) {
            log.error("导入失败，原因：" + e);
            throw new Exception("导入失败");
        }
    }

    @PostMapping("/model")
    public void testModel(String id ,String name){
    }

    @PostMapping("/modelAnn")
    public void testModel(@Validated @RequestBody modela m, BindingResult bindingResult){
        System.out.println(m.getId());
        System.out.println(m.getName());
        if (bindingResult.hasErrors()){
            for (FieldError error:bindingResult.getFieldErrors()){
                log.info("参数:{}校验失败，原因：{}",error.getField(),error.getDefaultMessage());
            }
        }
        helloService.helloService();
    }

    @PostMapping("/mail")
    public void testMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("第一封测试邮件");
        message.setText("邮件测试。。。");
        message.setFrom("602042981@qq.com");
        message.setTo("panchi@cmhi.chinamobile.com");
        mailSender.send(message);
        System.out.println("haha");
        System.out.println("dd");
    }

}
