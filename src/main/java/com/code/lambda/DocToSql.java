package com.code.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * User:甘琪 DateTime: 2016/4/9.
 */
public class DocToSql {

    private static String table;

    public static void main(String[] args) {

        String str = "product\n" +
                "\n" +
                "字段名\t字段描述\t类型长度\t备注\n" +
                "productid\t产品线Id\tint(11)\t\n" +
                "productname\t产品线名称\tvarchar(32)\t\n" +
                "createtime\t创建时间\tdatetime";

//        System.out.println(build(str));

        List<Field> fieldList = getfieldList(str);
        System.out.println(printResultMap(fieldList));
        System.out.println(printBaseColumn(fieldList));
        System.out.println();
        System.out.println(printInsert(fieldList));
        System.out.println();
        System.out.println(printUpdate(fieldList));
        System.out.println();
        System.out.println(printFindList(fieldList));
    }

    private static List<Field> getfieldList(String doc) {
        String[] arr = doc.split("\n");
        table = arr[0].trim();
        List<Field> fieldList = new ArrayList<>();
        for (int i = 3; i < arr.length; i++) {
            if (!arr[i].contains("\t")) {
                continue;
            }

            Field field = new Field();

            String[] fs = arr[i].split("\t");
            field.setName(formatFieldName(fs[0]));
            field.setType(formatFieldType(fs[2]));
            fieldList.add(field);
        }
        return fieldList;
    }

    private static String printFindList(List<Field> fieldList){
        StringBuilder sb = new StringBuilder();
        sb.append("<select id=\"findList\" resultMap=\"sysUser\">SELECT * FROM ").append(table).append(" \n<where>");
        for (Field field : fieldList) {
            sb.append("\n<if test=\"").append(field.getName()).append(" != null\">AND ").append(field.getName()).append("=#{").append(field.getName()).append("}</if>");
        }
        sb.append("\n</where>\n" +
                "</select>");
        return sb.toString();
    }

    private static String printUpdate(List<Field> fieldList){
        StringBuilder sb = new StringBuilder();
        sb.append("<update id=\"update\">UPDATE ").append(table).append(" set\n");
        for (Field field : fieldList) {
            sb.append(field.getName()).append("=#{").append(field.getName()).append("},");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("\nwhere ").append(fieldList.get(0).getName()).append("=#{").append(fieldList.get(0).getName()).append("}");
        sb.append("\n</update>");
        return sb.toString();
    }


    private static String printInsert(List<Field> fieldList){
        StringBuilder sb = new StringBuilder();
        sb.append("<insert id=\"insert\">INSERT INTO ").append(table).append(" (<include refid=\"base_column\"/>) VALUES \n(");
        for (Field field : fieldList) {
            sb.append("#{").append(field.getName()).append("},");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")\n</insert>");
        return sb.toString();
    }

    private static String printBaseColumn(List<Field> fieldList){
        StringBuilder sb = new StringBuilder();
        sb.append("<sql id=\"base_column\">");
        for (Field field : fieldList) {
           sb.append(field.getName()).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("</sql>");
        return sb.toString();
    }


    private static String printResultMap(List<Field> fieldList) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fieldList) {
            sb.append(" <id property=\"").append(field.getName()).append("\" column=\"").append(field.getName()).append("\"/>\n");
        }
        return sb.toString();
    }

    private static String build(String doc) {

        String[] arr = doc.split("\n");
        String tableName = arr[0].trim();
        List<Field> fieldList = new ArrayList<>();
        for (int i = 3; i < arr.length; i++) {
            if (!arr[i].contains("\t")) {
                continue;
            }
            Field field = new Field();
            String[] fs = arr[i].split("\t");
            field.setName(formatFieldName(fs[0]));
            field.setType(formatFieldType(fs[2]));
            fieldList.add(field);
        }

        return filter(createSql(tableName, fieldList));
    }

    private static String filter(String sql) {
        return sql;
    }

    private static String createSql(String tableName, List<Field> fieldList) {
        StringBuilder sb = new StringBuilder();
        sb.append("create table ").append(tableName).append("(");
        for (int i = 0; i < fieldList.size(); i++) {
            Field f = fieldList.get(i);
            sb.append(f.getName()).append(" ").append(f.getType());
            if (i < fieldList.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(");");
        return sb.toString();
    }

    private static String formatFieldName(String str) {
        return str;
    }


    private static String formatFieldType(String str) {
        return str;
    }

    static class Field {
        String name;
        String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
