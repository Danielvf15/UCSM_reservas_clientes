package ucsm.reservas_clientes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class ubicacion extends Fragment{
    private MapView mMapView;
    private GoogleMap mMap;
    private Bundle mBundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ubicacion, container, false);
        MapsInitializer.initialize(getActivity());//Inicializa el mapa
        mMapView = (MapView) view.findViewById(R.id.map);//Ubicas el id del mapa
        mMapView.onCreate(mBundle);//Crecion
        setUpMapIfNeeded(view);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = savedInstanceState;
    }

    private void setUpMapIfNeeded(View inflatedView) {//Metodo para revisar el contenido del mapa
        if (mMap == null) {
            mMapView = ((MapView) inflatedView.findViewById(R.id.map));
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {//Metodo que añade una marca al mapa
        mMap.addMarker(new MarkerOptions().position(new LatLng( -16.405739, -71.548794)).title("Marker"));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }
}
