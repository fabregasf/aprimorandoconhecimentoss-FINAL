package com.example.aprimorandoconhecimentoss.ui.pdf

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aprimorandoconhecimentoss.databinding.FragmentPdfvisualizadorBinding


private const val RELOAD_COUNT = "reload_count"
private const val RELOAD_ALLOW = 6

class PdfVisualizador : Fragment() {

    private var _binding: FragmentPdfvisualizadorBinding? = null

    val binding get() = _binding!!

    private var PDF_VIEWER_URL = "https://docs.google.com/gview?embedded=true&url="
    private var url: String? = null
    private var tipopdf: String? = null
    private var i = 0
    private var txtView: TextView? = null


    private var reloadCount = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPdfvisualizadorBinding.inflate(inflater, container, false)

        return binding.root
    }



    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        url = arguments?.getString("urlpdf")
        tipopdf = arguments?.getString("tipopdf")


        val webView = _binding!!.viewPdf
        val progressBar = _binding!!.progressbarPdf
        val texto = _binding!!.labelprogress
        val settings = webView.settings


        settings.javaScriptEnabled = true
        // Enable DOM storage API.
        settings.domStorageEnabled = true

        // Enable zooming in web view.
        settings.setSupportZoom(true)

        // Allow pinch to zoom.
        settings.builtInZoomControls = true

        // Disable the default zoom controls on the page.
        settings.displayZoomControls = false

        // Enable responsive layout.
        settings.useWideViewPort = false

        // Zoom out if the content width is greater than the width of the viewport.
        settings.loadWithOverviewMode = false

        val urlString: String = PDF_VIEWER_URL + url


        webView.webViewClient = DefaultWebViewClient()
        webView.loadUrl(urlString)

        Log.d("LOG_TAG_TIPO", "Pdf selecionado: $tipopdf")
        Log.d("LOG_TAG", "Loading URL: $urlString")

    }

    private class DefaultWebViewClient : WebViewClient() {

        private var bindi: FragmentPdfvisualizadorBinding? = null
        private var progressBar: ProgressBar? = bindi?.progressbarPdf
        private var texto: TextView? = bindi?.labelprogress

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            url: String
        ): Boolean {
            return true
        }

        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            view.visibility =View.INVISIBLE
            progressBar?.visibility = View.VISIBLE
            texto?.visibility = View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url)
            view?.visibility =View.VISIBLE
            progressBar?.visibility = View.INVISIBLE
            texto?.visibility = View.INVISIBLE
        }
    }

    /*internal open class DefaultWebChromeClient : WebChromeClient() {
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

private fun WebView.setWebViewClient(webChromeClient: WebChromeClient) {

}
