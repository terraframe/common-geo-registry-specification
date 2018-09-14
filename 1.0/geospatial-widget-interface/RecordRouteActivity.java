/**
 * Activity displaying a map where user can record routes by clicking on the map
 * G1.1
 * 
 */
public class RecordRouteActivity implements WidgetMapView.OnRecordRouteListener {

   /**  */
   private WidgetMapView mapView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       // Mapbox Access token
       Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

       setContentView(R.layout.activity_main);

       mapView = findViewById(R.id.mapView);
       mapView.setRecording(true);          //  Activate the recording
       mapView.setActivity(this);

       mapView.onCreate(savedInstanceState);
   }
}
