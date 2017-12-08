package com.example.ke.ibetatesting.constant;

/**
 * Created by ke on 11/23/17.
 */

public class SQLCommand {
    public static String QUERY_6 = "select LBCallNum, Count(*) from CheckOut Group By LBCallNum";
    public static String QUERY_7 = "select CheckOut.STID, SUM(COFine) from Checkout Group by CheckOut.STID";

    public static String RETURN_BOOK = "update checkout set coreturned=? where stid=? and lbcallnum=?";

    public static String CHECK_BOOK = "insert into checkout(stid,lbcallnum,coduedate,coreturned) values(?,?,?,?)";

    //checkout summary
    public static String CHECKOUT_SUMMARY = "select strftime('%m',coduedate) as month,count(*) as total from checkout where strftime('%Y',coduedate)='2011' group by month order by total desc";

    //public static String CHECKOUT_LIST = "select checkout.stid as _id, lbtitle, coduedate,coreturned,cofine,stname from checkout,student,libbook where student.stid=checkout.stid and libbook.lbcallnum=checkout.lbcallnum";

    public static String RECORD_LIST ="select Case_file.Device_SN as _id, Case_file.Tester_ID,Call_actDateTime from Case_file";
    public static String signup_ADDTESTER = "insert into Tester(Tester_ID,Tester_Pass) values(?,?)";

    public static String insertLocationData = "insert into Location (BC_lat,BC_lon,GOG_lat,GOG_lon,Location_desc,Location_type) VALUES(?,?,?,?,?,?)";

    public static String insertDeviceInfoData = "insert into Device (Device_SN, Device_desc, Device_Ver) values(?,?,?)";

    public static String insertNewCaseFileData = "insert into Case_file(BC_lat,BC_lon,GOG_lat,GOG_lon,Location_desc,Location_type,Device_SN,Tester_ID,Call_actDateTime,Call_conDateTime,Activiation_type,Test_City) values(?,?,?,?,?,?,?,?,?,?,?,?)";
}
