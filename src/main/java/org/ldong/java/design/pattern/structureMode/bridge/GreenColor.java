package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 14:00
 */
public class GreenColor implements ColorImplementor {

    public void printColor() {
        System.out.println("print the green color");
    }
}
