package com.wjspc.controller;

import com.wjspc.domain.User;
import com.wjspc.service.UserService;
import com.wjspc.util.Excel2007Utils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 79445 on 2018/10/3.
 */
@Controller
@RequestMapping("/excel01")
public class ExcelController {

    @Resource
    private UserService userService;

    /**
     * excel测试
     * @return
     */
    @RequestMapping(value = "/01",
            method = RequestMethod.GET)
    public void test01(){

        List<User> userList = userService.getUserList();

       // escelTest01(user);
      //  escelTest02(userList);
        escelTest03(userList);

    }

    /**
     *
     * @param user
     */
    private void escelTest01(User user) {

        try {
            String filePath = "C:\\Users\\79445\\Desktop\\user.xls";//文件路径
            HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
            HSSFSheet sheet = workbook.createSheet("sheet01");// 创建工作表(Sheet)
            HSSFRow row = sheet.createRow(0);// 创建行,从0开始
            HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
            cell.setCellValue("cell");// 设置单元格内容
            row.createCell(1).setCellValue(user.getUserName());// 设置单元格内容,重载
            row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
            row.createCell(3).setCellValue(user.getEmail());// 设置单元格内容,重载
            row.createCell(3).setCellValue(user.getPassword());// 设置单元格内容,重载
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);//保存Excel文件
            out.close();//关闭文件流
            System.out.println("OK!");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void escelTest02(User user) {
        try {
            String sheetName = "测试ExcelsheetName";
            String sheetTitle = "测试ExcelsheetTitle";
            List<String> columnNames = new LinkedList<>();
            columnNames.add("日期-String");
            columnNames.add("日期-Date");
            columnNames.add("时间戳-Long");
            columnNames.add("客户编码");
            columnNames.add("整数");
            columnNames.add("带小数的正数");

            //写入标题--第二种方式
            // Excel2007Utils.writeExcelTitle("C:\\Users\\79445\\Desktop", "user3", sheetName, columnNames, sheetTitle, false);

            List<List<Object>> objects = new LinkedList<>();
            for (int i = 0; i < 1000; i++) {
                List<Object> dataA = new LinkedList<>();
                dataA.add("2016-09-05 17:27:25");
                dataA.add(new Date(1451036631012L));
                dataA.add(1451036631012L);
                dataA.add("000628");
                dataA.add(i);
                dataA.add(1.323 + i);
                objects.add(dataA);
            }

            //写入数据--第二种方式
            //  Excel2007Utils.writeExcelData("C:\\Users\\79445\\Desktop", "user", sheetName, objects);

            //直接写入数据--第一种方式
            Excel2007Utils.writeExcel("C:\\Users\\79445\\Desktop", "user2", sheetName, columnNames, sheetTitle, objects, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void escelTest03(List<User> userList) {
        try {
            String sheetName = "测试sheetName";
            String sheetTitle = "测试sheetTitle";
            List<String> columnNames = new LinkedList<>();
            columnNames.add("编号");
            columnNames.add("用户名");
            columnNames.add("密码");
            columnNames.add("邮箱");

            List<List<Object>> objects = new LinkedList<>();
            for (int i = 0; i < userList.size() ; i++) {
                List<Object> dataA = new LinkedList<>();
                dataA.add(i+1);
                dataA.add(userList.get(i).getUserName());
                dataA.add(userList.get(i).getPassword());
                dataA.add(userList.get(i).getEmail());
                objects.add(dataA);
            }

            Excel2007Utils.writeExcel(null, "user2", sheetName, columnNames, sheetTitle, objects, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
