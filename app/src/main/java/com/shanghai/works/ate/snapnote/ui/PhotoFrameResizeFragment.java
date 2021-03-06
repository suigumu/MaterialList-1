package com.shanghai.works.ate.snapnote.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.shanghai.works.ate.snapnote.R;
import com.shanghai.works.ate.snapnote.ui.view.ImageTrimView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.shanghai.works.ate.snapnote.ui.PhotoFrameResizeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.shanghai.works.ate.snapnote.ui.PhotoFrameResizeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFrameResizeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageButton photoResizeOK;

    private ImageTrimView imageTrimView;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param photoUrl Parameter 1.
     * @return A new instance of fragment PhotoFrameResizeFragmentOld.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoFrameResizeFragment newInstance(String photoUrl, String param2) {
        PhotoFrameResizeFragment fragment = new PhotoFrameResizeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, photoUrl);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PhotoFrameResizeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View photoFrameResizeLayout = inflater.inflate(R.layout.fragment_photo_frame_resize, container, false);
        photoResizeOK = (ImageButton)photoFrameResizeLayout.findViewById(R.id.photo_resize_ok);
        imageTrimView = (ImageTrimView) photoFrameResizeLayout.findViewById(R.id.image_trim_view);
        setUpClickListenerForOKBtn(null);
        return photoFrameResizeLayout;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onPhotoFrameResizeFragmentOKButtonClickInteraction(Uri uri);
    }

    public byte[] getTrimmedImage() {
        return this.imageTrimView.getTrimmedImage();
    }


    private void setUpClickListenerForOKBtn(final Uri uri){
        photoResizeOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mListener.onPhotoFrameResizeFragmentOKButtonClickInteraction(uri);
            Log.d("", "OK Btn Clicked.");
            }
        });
    }
}
