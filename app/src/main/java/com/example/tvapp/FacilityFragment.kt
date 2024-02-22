package com.example.tvapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FacilityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FacilityFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var recyclerView: RecyclerView? = null
    private var recyclerViewFacilityAdapter: RecyclerViewFacilityAdapter? = null
    private var facilityList: MutableList<Facility> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_facility, container, false)

        facilityList = ArrayList()

        recyclerView = view.findViewById<View>(R.id.rvfacility) as RecyclerView
        recyclerViewFacilityAdapter = RecyclerViewFacilityAdapter(this, facilityList)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireContext(), 3)

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewFacilityAdapter

        prepareFacilityListData()

        return view
    }

    private fun prepareFacilityListData() {
        var facility = Facility("Gym", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Restaurant", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Bar", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Pool", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Working Space", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Rooftop", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("BBQ Night", R.drawable.gym)
        facilityList.add(facility)
        facility = Facility("Spa", R.drawable.gym)
        facilityList.add(facility)

        // Notify the adapter that the data has changed
        recyclerViewFacilityAdapter?.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FacilityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



//Expecting ','
//Type mismatch: inferred type is FacilityFragment but Context! was expected
//There should be no space or comments before '@' in label reference
//Unresolved reference: VIew
//Unresolved reference: findViewById