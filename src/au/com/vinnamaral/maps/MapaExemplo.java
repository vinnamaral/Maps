package au.com.vinnamaral.maps;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;

public class MapaExemplo extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa_exemplo);
		
		MapView mapa = (MapView) findViewById(R.id.mapa);
		
		//Ativar o zoom
		mapa.setBuiltInZoomControls(true);
		mapa.displayZoomControls(true);
		
		MapController mc = mapa.getController();
		
		//Define boneco
		List<Overlay> mapOverlays = mapa.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
		OverlayUtil itemizedoverlay = new OverlayUtil(drawable, this);
		
		//Cria boneco
		GeoPoint p = new GeoPoint((int) (-29.339003 * 1E6), (int) (-49.727007 * 1E6));
		
		OverlayItem overlayitem = new OverlayItem(p, "Informações da venda", "Aqui poderia ser capturado informações, etc");
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		mc.setCenter(p);
		
		mc.animateTo(p);
		
		mc.setZoom(30);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


}
