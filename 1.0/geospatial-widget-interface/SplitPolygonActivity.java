/**
 * Activity displaying a map while splitting a polygon
 * G2.4
 * 
 */
public class SplitPolygonActivity extends AppCompatActivity {

    /**  */
    private WidgetMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox Access token
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        mapView.setPlittingPolygon(true);          //  Activate the split of polygon
        mapView.setActivity(this);

        mapView.onCreate(savedInstanceState);
    }

    
}
