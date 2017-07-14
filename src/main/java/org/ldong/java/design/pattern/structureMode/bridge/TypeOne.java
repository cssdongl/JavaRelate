package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 14:09
 */
public class TypeOne extends AbstractType {
    protected void writeSth() {
        System.out.println("this is type one");
        implementor.printColor();
    }
}
