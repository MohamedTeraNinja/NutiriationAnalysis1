package com.mohammedragab.nutiriationanalysis1.analysisdata
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mohammedragab.nutiriationanalysis1.MainActivity
import com.mohammedragab.nutiriationanalysis1.R
import com.mohammedragab.nutiriationanalysis1.databinding.HistoryNutritionAnalyzeDataBinding
import com.mohammedragab.nutiriationanalysis1.presentationlayer.AnalysisViewModel
import com.mohammedragab.nutiriationanalysis1.presentationlayer.ViewModelFactory
import com.teraninjas.mazadat.utility.Utile
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 * this fragment  for  add data for analysis  fragment  it have all category for
 *
 */

class HistoryDataNutritionAnalysisFragment :Fragment() {
    private  val TAG = "AddDataAnalysisFragment"
   private lateinit var binding: HistoryNutritionAnalyzeDataBinding
//    private  lateinit var auctionSliderAdapter:AuctionSliderAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var analysisViewModel: AnalysisViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
           (activity as MainActivity).analysisComponent.inject(this)
            analysisViewModel = ViewModelProvider(this, viewModelFactory).get(AnalysisViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.history_nutrition_analyze_data, container, false)
        binding.lifecycleOwner = this

        initAdapter()
        initObserver()

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.to_total_calculation)
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
       // homeViewModel.getCategoryAuctionHomeData()

    }

    override fun onDestroy() {
        super.onDestroy() }
    override fun onResume() {
        super.onResume() }

    override fun onPause() {
        super.onPause() }

    fun initAdapter(){
//todo  we will handle adapter here
        // data will depend on remote data and  local data




    }



    fun initObserver(){

        analysisViewModel.responseErrorMessage.observe(viewLifecycleOwner, Observer {

            if (it!=null){

                Utile.showSucesSnakbar(binding.textView2,it)
            }else{

            }
        })




    }


}