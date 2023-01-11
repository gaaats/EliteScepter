package com.sinyee.babyb.brorororo


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.sinyee.babyb.R
import com.sinyee.babyb.databinding.ActivityBrooovserBinding
import com.sinyee.babyb.oothththt.Constance
import com.sinyee.babyb.oothththt.DataStoreManager
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.advertIDDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.appsCheckerDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.instIDDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.linkCheckerDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.namingDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.randomUUIDDataStoreKey
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException
import javax.inject.Inject


@AndroidEntryPoint
@ActivityScoped
class BrooovserActivity : AppCompatActivity() {

    var myTrIDgtgt = Constance.KEY_NO_DATA
    var myInstIdgt = Constance.KEY_NO_DATA
    var gttgcpOne = Constance.KEY_NO_DATA
    var gtgtgmainId = Constance.KEY_NO_DATA

    var checkFlyyybh = Constance.KEY_NO_DATA

    var linkABgtgt = Constance.KEY_NO_DATA

    @Inject
    lateinit var dataManager: DataStoreManager

    private val ofjpeorjfperjg = 1

    var hfgjrtgjhkh: ValueCallback<Array<Uri>>? = null
    var kgjfhdkxf: String? = null
    lateinit var jgidhgjdk: WebView
    lateinit var hrfghrdssxc: ActivityBrooovserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hrfghrdssxc = ActivityBrooovserBinding.inflate(layoutInflater)
        setContentView(hrfghrdssxc.root)

        jgidhgjdk = hrfghrdssxc.vvvvvvvvvvvv
        Snackbar.make(
            hrfghrdssxc.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val cmngcmng = CookieManager.getInstance()
        cmngcmng.setAcceptCookie(true)
        cmngcmng.setAcceptThirdPartyCookies(jgidhgjdk, true)
        bgbbbgb()
        val gtgtgtg: Activity = this
        jgidhgjdk.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (nhnjkkkk(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                gtgtgtgt(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(gtgtgtg, description, Toast.LENGTH_SHORT).show()
            }


        }
        jgidhgjdk.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                hfgjrtgjhkh?.onReceiveValue(null)
                hfgjrtgjhkh = filePathCallback
                var yttgtgtggt: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (yttgtgtggt!!.resolveActivity(packageManager) != null) {

                    var ggtgtgtgt: File? = null
                    try {
                        ggtgtgtgt = createImageFile()
                        yttgtgtggt.putExtra("PhotoPath", kgjfhdkxf)
                    } catch (ex: IOException) {
                    }

                    if (ggtgtgtgt != null) {
                        kgjfhdkxf = "file:" + ggtgtgtgt.absolutePath
                        yttgtgtggt.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(ggtgtgtgt)
                        )
                    } else {
                        yttgtgtggt = null
                    }
                }
                val cocococ = Intent(Intent.ACTION_GET_CONTENT)
                cocococ.addCategory(Intent.CATEGORY_OPENABLE)
                cocococ.type = "image/*"
                val intentArrayyyyy: Array<Intent?> =
                    yttgtgtggt?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val chooserIntenttttt = Intent(Intent.ACTION_CHOOSER)
                chooserIntenttttt.putExtra(Intent.EXTRA_INTENT, cocococ)
                chooserIntenttttt.putExtra(
                    Intent.EXTRA_TITLE,
                    getString(R.string.image_chooser)
                )
                chooserIntenttttt.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArrayyyyy)
                startActivityForResult(
                    chooserIntenttttt, ofjpeorjfperjg
                )
                return true
            }

            @Throws(IOException::class)
            private fun createImageFile(): File {
                var imageStorageDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!imageStorageDir.exists()) {
                    imageStorageDir.mkdirs()
                }

                imageStorageDir =
                    File(imageStorageDir.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return imageStorageDir
            }

        }

        jgidhgjdk.loadUrl(rfrfr())
    }


    private fun gtgtgtgtgeddc(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val gtgttgt = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $gtgttgt"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val gtgttt =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $gtgttt"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val gtgtgttg = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $gtgtgttg"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun bgbbbgb() {
        val wstwstwstwst = jgidhgjdk.settings
        wstwstwstwst.javaScriptEnabled = true

        wstwstwstwst.useWideViewPort = true

        wstwstwstwst.loadWithOverviewMode = true
        wstwstwstwst.allowFileAccess = true
        wstwstwstwst.domStorageEnabled = true
        wstwstwstwst.userAgentString = wstwstwstwst.userAgentString.replace("; wv", "")

        wstwstwstwst.javaScriptCanOpenWindowsAutomatically = true
        wstwstwstwst.setSupportMultipleWindows(false)

        wstwstwstwst.displayZoomControls = false
        wstwstwstwst.builtInZoomControls = true
        wstwstwstwst.setSupportZoom(true)

        wstwstwstwst.pluginState = WebSettings.PluginState.ON
        wstwstwstwst.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        wstwstwstwst.setAppCacheEnabled(true)

        wstwstwstwst.allowContentAccess = true
    }

    private fun rfrfr(): String {

        val spoonfrgt = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val packkkk = Constance.PACK_NAME

        val onetgtg = "deviceID="
        val subOnegtgt = "sub_id_1="
        val thrhtrhtrhtrhtgtg = "ad_id="
        val fofofofofofofofofogttg = "sub_id_4="
        val fifififififififififgt = "sub_id_5="
        val sisisisifsisisgt = "sub_id_6="

        val lolololololologt = "naming"

        val kiokjjlikjhmkijgt = Build.VERSION.RELEASE

        var aftgtgtt = ""

        lifecycleScope.launch {
            myTrIDgtgt = dataManager.readStringFromDataStore(key = randomUUIDDataStoreKey)
                ?: Constance.KEY_NO_DATA
            myInstIdgt = dataManager.readStringFromDataStore(key = instIDDataStoreKey)
                ?: Constance.KEY_NO_DATA
            gttgcpOne = dataManager.readStringFromDataStore(key = namingDataStoreKey)
                ?: Constance.KEY_NO_DATA
            gtgtgmainId = dataManager.readStringFromDataStore(key = advertIDDataStoreKey)
                ?: Constance.KEY_NO_DATA
            checkFlyyybh = dataManager.readStringFromDataStore(key = appsCheckerDataStoreKey)
                ?: Constance.KEY_NO_DATA
            linkABgtgt = dataManager.readStringFromDataStore(key = linkCheckerDataStoreKey)
                ?: Constance.KEY_NO_DATA

//            delay(1500)
//            Snackbar.make(
//                hrfghrdssxc.root, "checkFly $checkFlyyybh",
//                Snackbar.LENGTH_SHORT
//            ).show()
//
//            delay(1500)
//            Snackbar.make(
//                hrfghrdssxc.root, "naming $gttgcpOne",
//                Snackbar.LENGTH_SHORT
//            ).show()
//            delay(1500)
//            Snackbar.make(
//                hrfghrdssxc.root, "advertID $gtgtgmainId",
//                Snackbar.LENGTH_SHORT
//            ).show()
//
//            delay(1500)
//            Snackbar.make(
//                hrfghrdssxc.root, "myTrID $myTrIDgtgt",
//                Snackbar.LENGTH_SHORT
//            ).show()
//
//            delay(1500)
//            Snackbar.make(
//                hrfghrdssxc.root, "myInstId $myInstIdgt",
//                Snackbar.LENGTH_SHORT
//            ).show()
        }


        val afIdddefr = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        if (checkFlyyybh == "yes") {
            aftgtgtt =
                "$linkABgtgt$subOnegtgt$gttgcpOne&$onetgtg$afIdddefr&$thrhtrhtrhtrhtgtg$gtgtgmainId&$fofofofofofofofofogttg$packkkk&$fifififififififififgt$kiokjjlikjhmkijgt&$sisisisifsisisgt$lolololololologt"
            gtgtgtgtgeddc(afIdddefr.toString())
        } else {
            aftgtgtt =
                "$linkABgtgt$onetgtg$myTrIDgtgt&$thrhtrhtrhtrhtgtg$myInstIdgt&$fofofofofofofofofogttg$packkkk&$fifififififififififgt$kiokjjlikjhmkijgt&$sisisisifsisisgt$lolololololologt"
            gtgtgtgtgeddc(myTrIDgtgt.toString())
        }

        return spoonfrgt.getString("SAVED_URL", aftgtgtt).toString()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != ofjpeorjfperjg || hfgjrtgjhkh == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(kgjfhdkxf))
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        hfgjrtgjhkh?.onReceiveValue(results)
        hfgjrtgjhkh = null
    }


    private var vgtgtgttg = false
    override fun onBackPressed() {


        if (jgidhgjdk.canGoBack()) {
            if (vgtgtgttg) {
                jgidhgjdk.stopLoading()
                jgidhgjdk.loadUrl(tgtgtgtg)
            }
            this.vgtgtgttg = true
            jgidhgjdk.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                vgtgtgttg = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    var tgtgtgtg = ""
    fun gtgtgtgt(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (tgtgtgtg == "") {
                tgtgtgtg = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val vfvfvf =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = vfvfvf.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }

    private fun nhnjkkkk(uri: String): Boolean {

        val pm = packageManager
        try {

            pm.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }
}