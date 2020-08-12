package com.pc.excelTest;

import com.pc.Enum.ExcelModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author panchi
 * @Type ExcelTest.java
 * @Desc
 * @date 2020/4/24 16:19
 */
@Slf4j
public class ExcelTest {

    @Test
    public void test() throws Exception {
        try {
            //拿到multipartfile
            //名字，打log info
            //判断后缀名

            List<ExcelModel> list = Lists.newArrayList();
            ExcelModel em = new ExcelModel();
            //放到Util中，返回一个List<ExcelModel>
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("/Users/pcmike/Desktop/付费产品类型导入模板.xlsx"));
            XSSFSheet sheet = xssfWorkbook.getSheet("付费产品");
            int lastRowNum = sheet.getLastRowNum();
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
                    if (payProduct.toString().length() > 10) {
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
                    if (appleId.toString().length() > 10 ) {
                        throw new Exception("appleId");///////
                    }
                }

                //封装对象
                String strTrim;

                if (payProduct != null && !"".equals(strTrim = payProduct.toString().trim())){
                    em.setPayProduct(strTrim);
                }

                if (priceType != null && !"".equals(strTrim = priceType.toString().trim())){
                    em.setPriceType(strTrim);
                }

                if (deviceType != null && !"".equals(strTrim = deviceType.toString().trim())){
                    em.setDeviceType(strTrim);
                }

                if (productPrice != null && !"".equals(strTrim = productPrice.toString().trim())){
                    try {
                        em.setProductPrice(new BigDecimal(strTrim));
                    } catch (Exception e) {
                        log.info("价格信息错误：{}"+strTrim);
                        throw new Exception("strTrim");
                    }
                }

                if (productId != null && !"".equals(strTrim = productId.toString().trim())){
                    em.setProductId(strTrim);
                }

                if (appleId != null && !"".equals(strTrim = appleId.toString().trim())){
                    em.setAppleId(strTrim);
                }

                list.add(em);

            }

            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/4/24 panchi create
 */ 
