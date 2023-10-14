//package com.app.util;
//
//import java.util.List;
//
//public class Security {
//
//    public void foo() {
//
//        addRestJPABoiler();
//        addDependency(List.of("spring sec", "sec test")); // sec
//        addSecurityConfig(); // sec-config
//        addClassUserInfoUserDetail(); // user-detail
//        addClassUserInfoUserDetailService(); // user-detail-service
//        addAuthorityToVerb(); //
//    }
//
//    private void addSecurityConfig() {
//        addAnnotation(List.of("web sec", "method sec"));
//        addBean(List.of("user info", "user detail", "user detail service"));
//    }
//
//    private void addClassUserInfoUserDetailService() {
//        itImplements("user detail service");
//    }
//
//    private void addClassUserInfoUserDetail() {
//        itImplements("user detail");
//        createField(List.of("name", "pass", "list of grant auth"));
//        addTheConstructor();// use-det-cons
//        metaInfo("return fields in overloaded methods");
//    }
//
//    private void metaInfo(String s) {
//
//    }
//
//    private void addTheConstructor() {
//
//    }
//
//    private void createField(List<String> userDetail) {
//    }
//
//    private void itImplements(String userDetail) {
//    }
//
//    private void addClassWhichImplements(List<String> userDetail) {
//    }
//
//    private void addAnnotation( List<String> strings) {
//
//    }
//
//    private void addAuthorityToVerb() {
//
//    }
//
//    private void addExternalConfig(List<String> strings) {
//    }
//
//    private void addRestJPABoiler(String loc, String bpn, String pk, String obj) {
//        addDependency(List.of("web", "test"));
//        addExternalConfig(List.of("db source", "db username", "db pass"));
////        addController(obj);
////        addService(obj);
////        addGetVerb(obj, 1);
////        addEntity(obj);
//        addRepo(obj, "long");
//    }
//
//    private void addRepo(String obj, String aLong) {
//
//    }
//
//    private void addBean(List<String> list) {
//
//    }
//
//    private void addDependency(List<String> list) {
//
//    }
//}
