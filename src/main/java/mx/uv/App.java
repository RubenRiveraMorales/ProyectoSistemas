package mx.uv;

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {

        staticFiles.location("/");
        System.out.println( "Holaaaaaa" );

    }
}
