package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 14:24
 */
public class TypeTwo extends AbstractType {
    protected void writeSth() {
        System.out.println("this is type two");
        implementor.printColor();
    }
}
