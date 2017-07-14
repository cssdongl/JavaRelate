package org.ldong.java.design.pattern.structureMode.bridge;

/**
 * @author cssdongl@gmail.com
 * @version V1.0
 * @date 2017/7/14 14:01
 */
public abstract class AbstractType {

    protected ColorImplementor implementor;

    public void setImplementor(ColorImplementor implementor) {
        this.implementor = implementor;
    }

    protected abstract void writeSth();
}
