package com.seg;

/**
 * @author SEGg9
 */
public class Boundaries
{
    public double top;
    public double bottom;
    public double left;
    public double right;
    private double height;
    private double width;
    
    public Boundaries (double top, double bottom, double left, double right)
    {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }
    
    public double getHeight ()
    {
        height = top-bottom;
        return height;
    }
    
    public double getWidth ()
    {
        width = right-left;
        return width;
    }
}
