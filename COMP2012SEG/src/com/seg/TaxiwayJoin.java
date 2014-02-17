package com.seg;

/**
 * @author SEGg9
 * 
 * This class is used to store all the necessary information about a taxiway join, which connects two 
 * {@link TaxiwaySection} objects.
 */
public class TaxiwayJoin
{
    final int UID;
    public final double joinX;
    public final double joinY;
    
    TaxiwayJoin (int uid, double x, double y)
    {
        UID = uid;
        joinX = x;
        joinY = y;
    }
}