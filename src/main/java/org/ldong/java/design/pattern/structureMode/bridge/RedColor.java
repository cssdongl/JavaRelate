package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 13:58
 */
public class RedColor implements ColorImplementor {
    public void printColor() {
        System.out.println("print red color");
    }
}
