/*
package com.zhiduoduo.fuck.generate;
 
import com.baomidou.mybatisplus.core.config.GlobalConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
*/
/**
 * <p>
 * ������������ʾ
 * </p>
 *//*

public class MpGenerator {
 
    */
/**
     * <p>
     * MySQL ������ʾ
     * </p>
     *//*

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // ѡ�� freemarker ���棬Ĭ�� Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
 
        // ȫ������
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Mht");
        gc.setOutputDir("E://fuck/");
        gc.setFileOverride(false);// �Ƿ񸲸�ͬ���ļ���Ĭ����false
        gc.setActiveRecord(true);// ����ҪActiveRecord���Ե����Ϊfalse
        gc.setEnableCache(false);// XML ��������
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        */
/* �Զ����ļ�������ע�� %s ���Զ�����ʵ�����ԣ� *//*

        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);
 
        // ����Դ����
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // �Զ������ݿ���ֶ�����ת������ѡ��
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("ת�����ͣ�" + fieldType);
                // ע�⣡��processTypeConvert ����Ĭ������ת�������������Ҫ��Ч�����Զ��巵�ء�������ֱ�ӷ��ء�
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/market_hedge?useUnicode=true&characterEncoding=utf8");
        mpg.setDataSource(dsc);
 
        // ��������
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// ȫ�ִ�д���� ORACLE ע��
        strategy.setTablePrefix(new String[] { "" });// �˴������޸�Ϊ���ı�ǰ׺
        strategy.setNaming(NamingStrategy.nochange);// �������ɲ���
        strategy.setInclude(new String[] { "position_spot_maker" }); // ��Ҫ���ɵı�
        // strategy.setExclude(new String[]{"test"}); // �ų����ɵı�
        //String biaoming=new String("OptionMaker");
        // �Զ���ʵ�常��
        //strategy.setSuperEntityClass("com.zhiduoduo.makemarket.models.domain."+biaoming+"Entity");
        // �Զ���ʵ�壬�����ֶ�
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // �Զ��� mapper ����
        //strategy.setSuperMapperClass("com.zhiduoduo.makemarket.models.mapper."+biaoming+"Mapper");
        // �Զ��� service ����
        //strategy.setSuperServiceClass("com.zhiduoduo.makemarket.models.service."+biaoming+"Service");
        // �Զ��� service ʵ���ุ��
        //strategy.setSuperServiceImplClass("com.zhiduoduo.makemarket.models.service.impl."+biaoming+"ServiceImpl");
        // �Զ��� controller ����
        //strategy.setSuperControllerClass("com.zhiduoduo.makemarket.models.controller."+biaoming+"Controller");
        // ��ʵ�塿�Ƿ������ֶγ�����Ĭ�� false��
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // ��ʵ�塿�Ƿ�Ϊ������ģ�ͣ�Ĭ�� false��
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);
 
        // ������
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zhiduoduo.makemarket.models");
//        pc.setModuleName("test");
        mpg.setPackageInfo(pc);
 
        // ע���Զ������ã������� VM ��ʹ�� cfg.abc �����ޡ�
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//
//        // �Զ��� xxList.jsp ����
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // �Զ��������ļ�����
//                return "D://my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // ���� xml ����Ŀ¼��ʾ
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // �ر�Ĭ�� xml ���ɣ��������� �� ��Ŀ¼
//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);
//        mpg.setTemplate(tc);
 
        // �Զ���ģ�����ã����� copy Դ�� mybatis-plus/src/main/resources/templates ���������޸ģ�
        // �����Լ���Ŀ�� src/main/resources/templates Ŀ¼��, Ĭ������һ�¿��Բ����ã�Ҳ�����Զ���ģ������
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // �����κ�һ��ģ��������� �� OR Null �������ɸ�ģ�顣
        // mpg.setTemplate(tc);
 
        // ִ������
        mpg.execute();
 
        // ��ӡע�����á����ޡ�
//        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
 
}*/
