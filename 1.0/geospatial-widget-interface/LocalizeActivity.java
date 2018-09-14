/**
 * Activity displaying a map with user location and direction
 * G3.2
 * 
 */
public class LocationActivity extends AppCompatActivity {

    /**  */
    private WidgetMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox Access token
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        mapView.setLocalisation(true);          //  Activate the localisation
        mapView.setActivity(this);

        mapView.onCreate(savedInstanceState);
    }

    
}
