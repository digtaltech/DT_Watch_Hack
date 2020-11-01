package dt.prot.bottom_menu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dt.prot.bottom_menu.R

class ProfileFragment : Fragment(), OnMapReadyCallback {
    var mMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        setCameraPosition(LatLng(55.749020, 37.623534), 10f)
        mMap?.setOnMarkerClickListener(OnMarkerClickListener { marker ->
            setCameraPosition(marker.position, 16f)
            false
        })
        mMap?.addMarker(MarkerOptions().position(LatLng(55.756911, 37.562438)).title("1"));
        mMap?.addMarker(MarkerOptions().position(LatLng(55.807084, 37.645614)).title("2"));
        mMap?.addMarker(MarkerOptions().position(LatLng(55.736446, 37.714943)).title("3"));
        mMap?.addMarker(MarkerOptions().position(LatLng(55.707802, 37.678545)).title("4"));
        mMap?.addMarker(MarkerOptions().position(LatLng(55.683114, 37.565435)).title("5"));

    }

    private fun setCameraPosition(position: LatLng, zoom: Float) {
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(position, zoom))
    }

}
