import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main {


    public static String storeUrl = "D:\\weatherPicture\\";
//    public static String storeUrl = "/home/tank/weather";


    public static  void  crawl()
    {
        // satellite map
        if(SatelliteMap.isTime())
        {
            ArrayList<String> temp =  SatelliteMap.getUrl();
            ArrayList<String> name = SatelliteMap.getName();

            for( int i = 0; i<temp.size() ; i++) {
                String SatelliteMapUrl = temp.get(i);
                boolean downloadResult  = DownloadPicture.download(SatelliteMapUrl, storeUrl, name.get(i) );
                SatelliteMap.isStoreOk = downloadResult;

            }
        }
        //wind filed map
        if( WindField.isTime())
        {
            ArrayList<String> temp =  WindField.getUrl();
            ArrayList<String> name = WindField.getName();

            for( int i = 0; i<temp.size() ; i++) {
                String WindFieldMapUrl = temp.get(i);
                boolean downloadResult  = DownloadPicture.download( WindFieldMapUrl, storeUrl, name.get(i) );
                WindField.isStoreOk = downloadResult;
            }
        }

        //VisibilityGraph
        if(VisibilityGraph.isTime())
        {
            ArrayList<String> temp =  VisibilityGraph.getUrl();
            ArrayList<String> name = VisibilityGraph.getName();

            for( int i = 0; i<temp.size() ; i++) {
                String VisibilityGraphUrl = temp.get(i);
                boolean downloadResult  = DownloadPicture.download( VisibilityGraphUrl, storeUrl, name.get(i) );
                VisibilityGraph.isStoreOk = downloadResult;
            }
        }
    }

    public  static void main(String argus [])
    {

        while( true)
        {
            crawl();
        }

    }


}
