package com.zhiduoduo.fuck.generate;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ��ʾ���ӣ�ִ�� main ��������̨����ģ������س��Զ����ɶ�Ӧ��ĿĿ¼��
public class CodeGenerator {

    /**
     * <p>
     * ��ȡ����̨����
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("������" + tip + "��");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("��������ȷ��" + tip + "��");
    }

    public static void main(String[] args) {
        // ����������
        AutoGenerator mpg = new AutoGenerator();

        // ȫ������
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("jobob");
        gc.setOpen(false);
        gc.setSwagger2(true); //ʵ������ Swagger2 ע��
        mpg.setGlobalConfig(gc);

        // ����Դ����
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/market_hedge?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // ������
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("ģ����"));
        pc.setParent("com.zhiduoduo.ant");
        mpg.setPackageInfo(pc);

        // �Զ�������
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // ���ģ�������� freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // ���ģ�������� velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // �Զ����������
        List<FileOutConfig> focList = new ArrayList<>();
        // �Զ������ûᱻ�������
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // �Զ�������ļ��� �� ����� Entity ������ǰ��׺���˴�ע�� xml �����ƻ���ŷ����仯����
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // �ж��Զ����ļ����Ƿ���Ҫ����
                checkDir("����Ĭ�Ϸ���������Ŀ¼");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // ����ģ��
        TemplateConfig templateConfig = new TemplateConfig();

        // �����Զ������ģ��
        //ָ���Զ���ģ��·����ע�ⲻҪ����.ftl/.vm, �����ʹ�õ�ģ�������Զ�ʶ��
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // ��������
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.zhiduoduo.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // ��������
        strategy.setSuperControllerClass("com.zhiduoduo.ant.common.BaseController");
        // д�ڸ����еĹ����ֶ�
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("���������Ӣ�Ķ��ŷָ�").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}