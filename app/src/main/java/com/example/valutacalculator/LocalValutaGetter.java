package com.example.valutacalculator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class gets the json from a string
 *
 *@author CKN
 *@version 1.0
 *@since 1.0
 */
public class LocalValutaGetter implements ValutaStatusGetter {

    /**
     * Method that gets the status
     *
     *@version 1.0
     *@since 1.0
     */
    @Override
    public Valuta getStatus() {
        Valuta valuta = new Valuta();
        try {
            JSONObject jsonObject = new JSONObject(getJsonString());
            valuta = new Valuta(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return valuta;
    }

    /**
     * Method that gets the json string
     *
     *@version 1.0
     *@since 1.0
     * @return the json in string format
     */
    private String getJsonString(){
        return "{\n" +
                "  \"success\":true,\n" +
                "  \"timestamp\":1620039544,\n" +
                "  \"base\":\"EUR\",\n" +
                "  \"date\":\"2021-05-03\",\n" +
                "  \"rates\":{\n" +
                "    \"AED\":4.428131,\n" +
                "    \"AFN\":93.806031,\n" +
                "    \"ALL\":123.668887,\n" +
                "    \"AMD\":630.030345,\n" +
                "    \"ANG\":2.172245,\n" +
                "    \"AOA\":788.811553,\n" +
                "    \"ARS\":112.703744,\n" +
                "    \"AUD\":1.5582,\n" +
                "    \"AWG\":2.170545,\n" +
                "    \"AZN\":2.05599,\n" +
                "    \"BAM\":1.959282,\n" +
                "    \"BBD\":2.443425,\n" +
                "    \"BDT\":102.552161,\n" +
                "    \"BGN\":1.961792,\n" +
                "    \"BHD\":0.454465,\n" +
                "    \"BIF\":2359.48573,\n" +
                "    \"BMD\":1.205524,\n" +
                "    \"BND\":1.607358,\n" +
                "    \"BOB\":8.356024,\n" +
                "    \"BRL\":6.555041,\n" +
                "    \"BSD\":1.210142,\n" +
                "    \"BTC\":2.0598726e-5,\n" +
                "    \"BTN\":89.647114,\n" +
                "    \"BWP\":13.146569,\n" +
                "    \"BYN\":3.098184,\n" +
                "    \"BYR\":23628.264709,\n" +
                "    \"BZD\":2.439317,\n" +
                "    \"CAD\":1.482209,\n" +
                "    \"CDF\":2412.252432,\n" +
                "    \"CHF\":1.099486,\n" +
                "    \"CLF\":0.03105,\n" +
                "    \"CLP\":856.763254,\n" +
                "    \"CNY\":7.804201,\n" +
                "    \"COP\":4524.704195,\n" +
                "    \"CRC\":747.533092,\n" +
                "    \"CUC\":1.205524,\n" +
                "    \"CUP\":31.946378,\n" +
                "    \"CVE\":110.461427,\n" +
                "    \"CZK\":25.784224,\n" +
                "    \"DJF\":215.431301,\n" +
                "    \"DKK\":7.436277,\n" +
                "    \"DOP\":68.74768,\n" +
                "    \"DZD\":160.919356,\n" +
                "    \"EGP\":18.875488,\n" +
                "    \"ERN\":18.085159,\n" +
                "    \"ETB\":50.755034,\n" +
                "    \"EUR\":1,\n" +
                "    \"FJD\":2.455289,\n" +
                "    \"FKP\":0.875662,\n" +
                "    \"GBP\":0.86896,\n" +
                "    \"GEL\":4.171061,\n" +
                "    \"GGP\":0.875662,\n" +
                "    \"GHS\":6.982517,\n" +
                "    \"GIP\":0.875662,\n" +
                "    \"GMD\":61.661913,\n" +
                "    \"GNF\":11987.115961,\n" +
                "    \"GTQ\":9.339308,\n" +
                "    \"GYD\":253.180215,\n" +
                "    \"HKD\":9.363453,\n" +
                "    \"HNL\":29.069451,\n" +
                "    \"HRK\":7.545977,\n" +
                "    \"HTG\":103.346775,\n" +
                "    \"HUF\":359.870485,\n" +
                "    \"IDR\":17384.556036,\n" +
                "    \"ILS\":3.913106,\n" +
                "    \"IMP\":0.875662,\n" +
                "    \"INR\":89.040945,\n" +
                "    \"IQD\":1765.570315,\n" +
                "    \"IRR\":50758.575962,\n" +
                "    \"ISK\":151.196264,\n" +
                "    \"JEP\":0.875662,\n" +
                "    \"JMD\":185.677639,\n" +
                "    \"JOD\":0.854744,\n" +
                "    \"JPY\":131.899928,\n" +
                "    \"KES\":129.845235,\n" +
                "    \"KGS\":102.226122,\n" +
                "    \"KHR\":4898.711081,\n" +
                "    \"KMF\":493.48139,\n" +
                "    \"KPW\":1084.971571,\n" +
                "    \"KRW\":1353.633815,\n" +
                "    \"KWD\":0.363285,\n" +
                "    \"KYD\":1.008485,\n" +
                "    \"KZT\":520.481223,\n" +
                "    \"LAK\":11382.546472,\n" +
                "    \"LBP\":1829.738535,\n" +
                "    \"LKR\":239.00202,\n" +
                "    \"LRD\":207.410227,\n" +
                "    \"LSL\":17.444136,\n" +
                "    \"LTL\":3.559598,\n" +
                "    \"LVL\":0.729209,\n" +
                "    \"LYD\":5.411478,\n" +
                "    \"MAD\":10.797255,\n" +
                "    \"MDL\":21.431533,\n" +
                "    \"MGA\":4607.635257,\n" +
                "    \"MKD\":61.706233,\n" +
                "    \"MMK\":1884.78837,\n" +
                "    \"MNT\":3436.529037,\n" +
                "    \"MOP\":9.67825,\n" +
                "    \"MRO\":430.371757,\n" +
                "    \"MUR\":49.188852,\n" +
                "    \"MVR\":18.589353,\n" +
                "    \"MWK\":954.132762,\n" +
                "    \"MXN\":24.446453,\n" +
                "    \"MYR\":4.947833,\n" +
                "    \"MZN\":69.425825,\n" +
                "    \"NAD\":17.262976,\n" +
                "    \"NGN\":494.638448,\n" +
                "    \"NIO\":42.264156,\n" +
                "    \"NOK\":10.008391,\n" +
                "    \"NPR\":143.434466,\n" +
                "    \"NZD\":1.679264,\n" +
                "    \"OMR\":0.464151,\n" +
                "    \"PAB\":1.210132,\n" +
                "    \"PEN\":4.581571,\n" +
                "    \"PGK\":4.303517,\n" +
                "    \"PHP\":57.912127,\n" +
                "    \"PKR\":185.332428,\n" +
                "    \"PLN\":4.549936,\n" +
                "    \"PYG\":7897.377918,\n" +
                "    \"QAR\":4.38929,\n" +
                "    \"RON\":4.926735,\n" +
                "    \"RSD\":117.807536,\n" +
                "    \"RUB\":91.177498,\n" +
                "    \"RWF\":1211.233816,\n" +
                "    \"SAR\":4.521189,\n" +
                "    \"SBD\":9.594337,\n" +
                "    \"SCR\":18.105107,\n" +
                "    \"SDG\":467.743314,\n" +
                "    \"SEK\":10.180105,\n" +
                "    \"SGD\":1.604872,\n" +
                "    \"SHP\":0.875662,\n" +
                "    \"SLL\":12338.535187,\n" +
                "    \"SOS\":704.026182,\n" +
                "    \"SRD\":17.062943,\n" +
                "    \"STD\":24989.467377,\n" +
                "    \"SVC\":10.588741,\n" +
                "    \"SYP\":1516.027328,\n" +
                "    \"SZL\":17.448383,\n" +
                "    \"THB\":37.61271,\n" +
                "    \"TJS\":13.801743,\n" +
                "    \"TMT\":4.231388,\n" +
                "    \"TND\":3.312752,\n" +
                "    \"TOP\":2.734004,\n" +
                "    \"TRY\":10.001687,\n" +
                "    \"TTD\":8.220249,\n" +
                "    \"TWD\":33.720875,\n" +
                "    \"TZS\":2795.609544,\n" +
                "    \"UAH\":33.593158,\n" +
                "    \"UGX\":4328.69746,\n" +
                "    \"USD\":1.205524,\n" +
                "    \"UYU\":53.222643,\n" +
                "    \"UZS\":12734.163126,\n" +
                "    \"VEF\":257777402865.61768,\n" +
                "    \"VND\":27793.349126,\n" +
                "    \"VUV\":132.051696,\n" +
                "    \"WST\":3.052057,\n" +
                "    \"XAF\":657.120066,\n" +
                "    \"XAG\":0.046095,\n" +
                "    \"XAU\":0.000678,\n" +
                "    \"XCD\":3.257988,\n" +
                "    \"XDR\":0.84179,\n" +
                "    \"XOF\":657.120066,\n" +
                "    \"XPF\":119.888939,\n" +
                "    \"YER\":301.893301,\n" +
                "    \"ZAR\":17.380458,\n" +
                "    \"ZMK\":10851.154055,\n" +
                "    \"ZMW\":27.037455,\n" +
                "    \"ZWL\":388.17887\n" +
                "  }\n" +
                "}";
    }
}
