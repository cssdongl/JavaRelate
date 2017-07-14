package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 14:10
 */
public class App {
    public static void main(String[] args){
        ColorImplementor imp = new GreenColor();
        AbstractType type = new TypeOne();
        type.setImplementor(imp);
        type.writeSth();

        ColorImplementor imp1 = new RedColor();
        AbstractType type1 = new TypeTwo();
        type1.setImplementor(imp1);
        type1.writeSth();

    }
}
