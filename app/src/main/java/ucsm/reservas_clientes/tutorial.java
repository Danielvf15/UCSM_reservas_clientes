package ucsm.reservas_clientes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class tutorial extends Fragment {
    View view;
    VideoView videoView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_tutorial, container, false);
        videoView=view.findViewById(R.id.video);
        Uri path=Uri.parse("android.resource://ucsm.reservas_clientes/"+R.raw.video);
        MediaController mediaController=new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(path);
        videoView.start();
        return view;
    }
}
