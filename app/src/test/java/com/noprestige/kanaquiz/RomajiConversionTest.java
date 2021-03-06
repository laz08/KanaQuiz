package com.noprestige.kanaquiz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RomajiConversionTest
{
    @Test
    public void toStringTest()
    {
        assertThat(RomajiConversion.convertKana("あ"), is("a"));
        assertThat(RomajiConversion.convertKana("い"), is("i"));
        assertThat(RomajiConversion.convertKana("う"), is("u"));
        assertThat(RomajiConversion.convertKana("え"), is("e"));
        assertThat(RomajiConversion.convertKana("お"), is("o"));
        assertThat(RomajiConversion.convertKana("か"), is("ka"));
        assertThat(RomajiConversion.convertKana("き"), is("ki"));
        assertThat(RomajiConversion.convertKana("く"), is("ku"));
        assertThat(RomajiConversion.convertKana("け"), is("ke"));
        assertThat(RomajiConversion.convertKana("こ"), is("ko"));
        assertThat(RomajiConversion.convertKana("が"), is("ga"));
        assertThat(RomajiConversion.convertKana("ぎ"), is("gi"));
        assertThat(RomajiConversion.convertKana("ぐ"), is("gu"));
        assertThat(RomajiConversion.convertKana("げ"), is("ge"));
        assertThat(RomajiConversion.convertKana("ご"), is("go"));
        assertThat(RomajiConversion.convertKana("きゃ"), is("kya"));
        assertThat(RomajiConversion.convertKana("きゅ"), is("kyu"));
        assertThat(RomajiConversion.convertKana("きょ"), is("kyo"));
        assertThat(RomajiConversion.convertKana("ぎゃ"), is("gya"));
        assertThat(RomajiConversion.convertKana("ぎゅ"), is("gyu"));
        assertThat(RomajiConversion.convertKana("ぎょ"), is("gyo"));
        assertThat(RomajiConversion.convertKana("さ"), is("sa"));
        assertThat(RomajiConversion.convertKana("し"), is("shi"));
        assertThat(RomajiConversion.convertKana("す"), is("su"));
        assertThat(RomajiConversion.convertKana("せ"), is("se"));
        assertThat(RomajiConversion.convertKana("そ"), is("so"));
        assertThat(RomajiConversion.convertKana("ざ"), is("za"));
        assertThat(RomajiConversion.convertKana("じ"), is("ji"));
        assertThat(RomajiConversion.convertKana("ず"), is("zu"));
        assertThat(RomajiConversion.convertKana("ぜ"), is("ze"));
        assertThat(RomajiConversion.convertKana("ぞ"), is("zo"));
        assertThat(RomajiConversion.convertKana("しゃ"), is("sha"));
        assertThat(RomajiConversion.convertKana("しゅ"), is("shu"));
        assertThat(RomajiConversion.convertKana("しょ"), is("sho"));
        assertThat(RomajiConversion.convertKana("じゃ"), is("ja"));
        assertThat(RomajiConversion.convertKana("じゅ"), is("ju"));
        assertThat(RomajiConversion.convertKana("じょ"), is("jo"));
        assertThat(RomajiConversion.convertKana("た"), is("ta"));
        assertThat(RomajiConversion.convertKana("ち"), is("chi"));
        assertThat(RomajiConversion.convertKana("つ"), is("tsu"));
        assertThat(RomajiConversion.convertKana("て"), is("te"));
        assertThat(RomajiConversion.convertKana("と"), is("to"));
        assertThat(RomajiConversion.convertKana("だ"), is("da"));
        assertThat(RomajiConversion.convertKana("ぢ"), is("ji"));
        assertThat(RomajiConversion.convertKana("づ"), is("zu"));
        assertThat(RomajiConversion.convertKana("で"), is("de"));
        assertThat(RomajiConversion.convertKana("ど"), is("do"));
        assertThat(RomajiConversion.convertKana("ちゃ"), is("cha"));
        assertThat(RomajiConversion.convertKana("ちゅ"), is("chu"));
        assertThat(RomajiConversion.convertKana("ちょ"), is("cho"));
        assertThat(RomajiConversion.convertKana("ぢゃ"), is("ja"));
        assertThat(RomajiConversion.convertKana("ぢゅ"), is("ju"));
        assertThat(RomajiConversion.convertKana("ぢょ"), is("jo"));
        assertThat(RomajiConversion.convertKana("な"), is("na"));
        assertThat(RomajiConversion.convertKana("に"), is("ni"));
        assertThat(RomajiConversion.convertKana("ぬ"), is("nu"));
        assertThat(RomajiConversion.convertKana("ね"), is("ne"));
        assertThat(RomajiConversion.convertKana("の"), is("no"));
        assertThat(RomajiConversion.convertKana("にゃ"), is("nya"));
        assertThat(RomajiConversion.convertKana("にゅ"), is("nyu"));
        assertThat(RomajiConversion.convertKana("にょ"), is("nyo"));
        assertThat(RomajiConversion.convertKana("は"), is("ha"));
        assertThat(RomajiConversion.convertKana("ひ"), is("hi"));
        assertThat(RomajiConversion.convertKana("ふ"), is("fu"));
        assertThat(RomajiConversion.convertKana("へ"), is("he"));
        assertThat(RomajiConversion.convertKana("ほ"), is("ho"));
        assertThat(RomajiConversion.convertKana("ば"), is("ba"));
        assertThat(RomajiConversion.convertKana("び"), is("bi"));
        assertThat(RomajiConversion.convertKana("ぶ"), is("bu"));
        assertThat(RomajiConversion.convertKana("べ"), is("be"));
        assertThat(RomajiConversion.convertKana("ぼ"), is("bo"));
        assertThat(RomajiConversion.convertKana("ぱ"), is("pa"));
        assertThat(RomajiConversion.convertKana("ぴ"), is("pi"));
        assertThat(RomajiConversion.convertKana("ぷ"), is("pu"));
        assertThat(RomajiConversion.convertKana("ぺ"), is("pe"));
        assertThat(RomajiConversion.convertKana("ぽ"), is("po"));
        assertThat(RomajiConversion.convertKana("ひゃ"), is("hya"));
        assertThat(RomajiConversion.convertKana("ひゅ"), is("hyu"));
        assertThat(RomajiConversion.convertKana("ひょ"), is("hyo"));
        assertThat(RomajiConversion.convertKana("びゃ"), is("bya"));
        assertThat(RomajiConversion.convertKana("びゅ"), is("byu"));
        assertThat(RomajiConversion.convertKana("びょ"), is("byo"));
        assertThat(RomajiConversion.convertKana("ぴゃ"), is("pya"));
        assertThat(RomajiConversion.convertKana("ぴゅ"), is("pyu"));
        assertThat(RomajiConversion.convertKana("ぴょ"), is("pyo"));
        assertThat(RomajiConversion.convertKana("ま"), is("ma"));
        assertThat(RomajiConversion.convertKana("み"), is("mi"));
        assertThat(RomajiConversion.convertKana("む"), is("mu"));
        assertThat(RomajiConversion.convertKana("め"), is("me"));
        assertThat(RomajiConversion.convertKana("も"), is("mo"));
        assertThat(RomajiConversion.convertKana("みゃ"), is("mya"));
        assertThat(RomajiConversion.convertKana("みゅ"), is("myu"));
        assertThat(RomajiConversion.convertKana("みょ"), is("myo"));
        assertThat(RomajiConversion.convertKana("ら"), is("ra"));
        assertThat(RomajiConversion.convertKana("り"), is("ri"));
        assertThat(RomajiConversion.convertKana("る"), is("ru"));
        assertThat(RomajiConversion.convertKana("れ"), is("re"));
        assertThat(RomajiConversion.convertKana("ろ"), is("ro"));
        assertThat(RomajiConversion.convertKana("りゃ"), is("rya"));
        assertThat(RomajiConversion.convertKana("りゅ"), is("ryu"));
        assertThat(RomajiConversion.convertKana("りょ"), is("ryo"));
        assertThat(RomajiConversion.convertKana("や"), is("ya"));
        assertThat(RomajiConversion.convertKana("ゆ"), is("yu"));
        assertThat(RomajiConversion.convertKana("よ"), is("yo"));
        assertThat(RomajiConversion.convertKana("わ"), is("wa"));
        assertThat(RomajiConversion.convertKana("ゐ"), is("wi"));
        assertThat(RomajiConversion.convertKana("ゑ"), is("we"));
        assertThat(RomajiConversion.convertKana("を"), is("wo"));
        assertThat(RomajiConversion.convertKana("ん"), is("n"));
        assertThat(RomajiConversion.convertKana("ア"), is("a"));
        assertThat(RomajiConversion.convertKana("イ"), is("i"));
        assertThat(RomajiConversion.convertKana("ウ"), is("u"));
        assertThat(RomajiConversion.convertKana("エ"), is("e"));
        assertThat(RomajiConversion.convertKana("オ"), is("o"));
        assertThat(RomajiConversion.convertKana("カ"), is("ka"));
        assertThat(RomajiConversion.convertKana("キ"), is("ki"));
        assertThat(RomajiConversion.convertKana("ク"), is("ku"));
        assertThat(RomajiConversion.convertKana("ケ"), is("ke"));
        assertThat(RomajiConversion.convertKana("コ"), is("ko"));
        assertThat(RomajiConversion.convertKana("ガ"), is("ga"));
        assertThat(RomajiConversion.convertKana("ギ"), is("gi"));
        assertThat(RomajiConversion.convertKana("グ"), is("gu"));
        assertThat(RomajiConversion.convertKana("ゲ"), is("ge"));
        assertThat(RomajiConversion.convertKana("ゴ"), is("go"));
        assertThat(RomajiConversion.convertKana("キャ"), is("kya"));
        assertThat(RomajiConversion.convertKana("キュ"), is("kyu"));
        assertThat(RomajiConversion.convertKana("キョ"), is("kyo"));
        assertThat(RomajiConversion.convertKana("ギャ"), is("gya"));
        assertThat(RomajiConversion.convertKana("ギュ"), is("gyu"));
        assertThat(RomajiConversion.convertKana("ギョ"), is("gyo"));
        assertThat(RomajiConversion.convertKana("サ"), is("sa"));
        assertThat(RomajiConversion.convertKana("シ"), is("shi"));
        assertThat(RomajiConversion.convertKana("ス"), is("su"));
        assertThat(RomajiConversion.convertKana("セ"), is("se"));
        assertThat(RomajiConversion.convertKana("ソ"), is("so"));
        assertThat(RomajiConversion.convertKana("ザ"), is("za"));
        assertThat(RomajiConversion.convertKana("ジ"), is("ji"));
        assertThat(RomajiConversion.convertKana("ズ"), is("zu"));
        assertThat(RomajiConversion.convertKana("ゼ"), is("ze"));
        assertThat(RomajiConversion.convertKana("ゾ"), is("zo"));
        assertThat(RomajiConversion.convertKana("シャ"), is("sha"));
        assertThat(RomajiConversion.convertKana("シュ"), is("shu"));
        assertThat(RomajiConversion.convertKana("ショ"), is("sho"));
        assertThat(RomajiConversion.convertKana("ジャ"), is("ja"));
        assertThat(RomajiConversion.convertKana("ジュ"), is("ju"));
        assertThat(RomajiConversion.convertKana("ジョ"), is("jo"));
        assertThat(RomajiConversion.convertKana("タ"), is("ta"));
        assertThat(RomajiConversion.convertKana("チ"), is("chi"));
        assertThat(RomajiConversion.convertKana("ツ"), is("tsu"));
        assertThat(RomajiConversion.convertKana("テ"), is("te"));
        assertThat(RomajiConversion.convertKana("ト"), is("to"));
        assertThat(RomajiConversion.convertKana("ダ"), is("da"));
        assertThat(RomajiConversion.convertKana("ヂ"), is("ji"));
        assertThat(RomajiConversion.convertKana("ヅ"), is("zu"));
        assertThat(RomajiConversion.convertKana("デ"), is("de"));
        assertThat(RomajiConversion.convertKana("ド"), is("do"));
        assertThat(RomajiConversion.convertKana("チャ"), is("cha"));
        assertThat(RomajiConversion.convertKana("チュ"), is("chu"));
        assertThat(RomajiConversion.convertKana("チョ"), is("cho"));
        assertThat(RomajiConversion.convertKana("ヂャ"), is("ja"));
        assertThat(RomajiConversion.convertKana("ヂュ"), is("ju"));
        assertThat(RomajiConversion.convertKana("ヂョ"), is("jo"));
        assertThat(RomajiConversion.convertKana("ナ"), is("na"));
        assertThat(RomajiConversion.convertKana("ニ"), is("ni"));
        assertThat(RomajiConversion.convertKana("ヌ"), is("nu"));
        assertThat(RomajiConversion.convertKana("ネ"), is("ne"));
        assertThat(RomajiConversion.convertKana("ノ"), is("no"));
        assertThat(RomajiConversion.convertKana("ニャ"), is("nya"));
        assertThat(RomajiConversion.convertKana("ニュ"), is("nyu"));
        assertThat(RomajiConversion.convertKana("ニョ"), is("nyo"));
        assertThat(RomajiConversion.convertKana("ハ"), is("ha"));
        assertThat(RomajiConversion.convertKana("ヒ"), is("hi"));
        assertThat(RomajiConversion.convertKana("フ"), is("fu"));
        assertThat(RomajiConversion.convertKana("ヘ"), is("he"));
        assertThat(RomajiConversion.convertKana("ホ"), is("ho"));
        assertThat(RomajiConversion.convertKana("バ"), is("ba"));
        assertThat(RomajiConversion.convertKana("ビ"), is("bi"));
        assertThat(RomajiConversion.convertKana("ブ"), is("bu"));
        assertThat(RomajiConversion.convertKana("ベ"), is("be"));
        assertThat(RomajiConversion.convertKana("ボ"), is("bo"));
        assertThat(RomajiConversion.convertKana("パ"), is("pa"));
        assertThat(RomajiConversion.convertKana("ピ"), is("pi"));
        assertThat(RomajiConversion.convertKana("プ"), is("pu"));
        assertThat(RomajiConversion.convertKana("ペ"), is("pe"));
        assertThat(RomajiConversion.convertKana("ポ"), is("po"));
        assertThat(RomajiConversion.convertKana("ヒャ"), is("hya"));
        assertThat(RomajiConversion.convertKana("ヒュ"), is("hyu"));
        assertThat(RomajiConversion.convertKana("ヒョ"), is("hyo"));
        assertThat(RomajiConversion.convertKana("ビャ"), is("bya"));
        assertThat(RomajiConversion.convertKana("ビュ"), is("byu"));
        assertThat(RomajiConversion.convertKana("ビョ"), is("byo"));
        assertThat(RomajiConversion.convertKana("ピャ"), is("pya"));
        assertThat(RomajiConversion.convertKana("ピュ"), is("pyu"));
        assertThat(RomajiConversion.convertKana("ピョ"), is("pyo"));
        assertThat(RomajiConversion.convertKana("マ"), is("ma"));
        assertThat(RomajiConversion.convertKana("ミ"), is("mi"));
        assertThat(RomajiConversion.convertKana("ム"), is("mu"));
        assertThat(RomajiConversion.convertKana("メ"), is("me"));
        assertThat(RomajiConversion.convertKana("モ"), is("mo"));
        assertThat(RomajiConversion.convertKana("ミャ"), is("mya"));
        assertThat(RomajiConversion.convertKana("ミュ"), is("myu"));
        assertThat(RomajiConversion.convertKana("ミョ"), is("myo"));
        assertThat(RomajiConversion.convertKana("ラ"), is("ra"));
        assertThat(RomajiConversion.convertKana("リ"), is("ri"));
        assertThat(RomajiConversion.convertKana("ル"), is("ru"));
        assertThat(RomajiConversion.convertKana("レ"), is("re"));
        assertThat(RomajiConversion.convertKana("ロ"), is("ro"));
        assertThat(RomajiConversion.convertKana("リャ"), is("rya"));
        assertThat(RomajiConversion.convertKana("リュ"), is("ryu"));
        assertThat(RomajiConversion.convertKana("リョ"), is("ryo"));
        assertThat(RomajiConversion.convertKana("ヤ"), is("ya"));
        assertThat(RomajiConversion.convertKana("ユ"), is("yu"));
        assertThat(RomajiConversion.convertKana("ヨ"), is("yo"));
        assertThat(RomajiConversion.convertKana("ワ"), is("wa"));
        assertThat(RomajiConversion.convertKana("ヰ"), is("wi"));
        assertThat(RomajiConversion.convertKana("ヱ"), is("we"));
        assertThat(RomajiConversion.convertKana("ヲ"), is("wo"));
        assertThat(RomajiConversion.convertKana("ン"), is("n"));
        assertThat(RomajiConversion.convertKana("ティ"), is("ti"));
        assertThat(RomajiConversion.convertKana("トゥ"), is("to"));
        assertThat(RomajiConversion.convertKana("ヂィ"), is("di"));
        assertThat(RomajiConversion.convertKana("ドゥ"), is("do"));
        assertThat(RomajiConversion.convertKana("チェ"), is("che"));
        assertThat(RomajiConversion.convertKana("ファ"), is("fa"));
        assertThat(RomajiConversion.convertKana("フィ"), is("fi"));
        assertThat(RomajiConversion.convertKana("フェ"), is("fe"));
        assertThat(RomajiConversion.convertKana("フォ"), is("fo"));
        assertThat(RomajiConversion.convertKana("シェ"), is("she"));
        assertThat(RomajiConversion.convertKana("ジェ"), is("je"));
        assertThat(RomajiConversion.convertKana("ヴァ"), is("va"));
        assertThat(RomajiConversion.convertKana("ヴィ"), is("vi"));
        assertThat(RomajiConversion.convertKana("ヴ"), is("vu"));
        assertThat(RomajiConversion.convertKana("ヴェ"), is("ve"));
        assertThat(RomajiConversion.convertKana("ヴォ"), is("vo"));
        assertThat(RomajiConversion.convertKana("ウィ"), is("wi"));
        assertThat(RomajiConversion.convertKana("ウェ"), is("we"));
        assertThat(RomajiConversion.convertKana("ウォ"), is("wo"));
        assertThat(RomajiConversion.convertKana("テュ"), is("tu"));
        assertThat(RomajiConversion.convertKana("ツァ"), is("tsa"));
        assertThat(RomajiConversion.convertKana("ツェ"), is("tse"));
        assertThat(RomajiConversion.convertKana("ディ"), is("di"));
        assertThat(RomajiConversion.convertKana("デュ"), is("du"));
        assertThat(RomajiConversion.convertKana("イィ"), is("yi"));
        assertThat(RomajiConversion.convertKana("イェ"), is("ye"));
        assertThat(RomajiConversion.convertKana("ウァ"), is("wa"));
        assertThat(RomajiConversion.convertKana("ウゥ"), is("wu"));
        assertThat(RomajiConversion.convertKana("ヴィェ"), is("vye"));
        assertThat(RomajiConversion.convertKana("キェ"), is("kye"));
        assertThat(RomajiConversion.convertKana("ギェ"), is("gye"));
        assertThat(RomajiConversion.convertKana("クァ"), is("kwa"));
        assertThat(RomajiConversion.convertKana("クィ"), is("kwi"));
        assertThat(RomajiConversion.convertKana("クェ"), is("kwe"));
        assertThat(RomajiConversion.convertKana("クォ"), is("kwo"));
        assertThat(RomajiConversion.convertKana("グァ"), is("gwa"));
        assertThat(RomajiConversion.convertKana("グィ"), is("gwi"));
        assertThat(RomajiConversion.convertKana("グェ"), is("gwe"));
        assertThat(RomajiConversion.convertKana("グォ"), is("gwo"));
        assertThat(RomajiConversion.convertKana("スィ"), is("si"));
        assertThat(RomajiConversion.convertKana("ズィ"), is("zi"));
        assertThat(RomajiConversion.convertKana("ツィ"), is("tsi"));
        assertThat(RomajiConversion.convertKana("ツォ"), is("tso"));
        assertThat(RomajiConversion.convertKana("テゥ"), is("tu"));
        assertThat(RomajiConversion.convertKana("デゥ"), is("du"));
        assertThat(RomajiConversion.convertKana("ニェ"), is("nye"));
        assertThat(RomajiConversion.convertKana("ヒェ"), is("hye"));
        assertThat(RomajiConversion.convertKana("ビェ"), is("bye"));
        assertThat(RomajiConversion.convertKana("ピェ"), is("pye"));
        assertThat(RomajiConversion.convertKana("フィェ"), is("fye"));
        assertThat(RomajiConversion.convertKana("ホゥ"), is("hu"));
        assertThat(RomajiConversion.convertKana("ミェ"), is("mye"));
        assertThat(RomajiConversion.convertKana("リェ"), is("rye"));
        assertThat(RomajiConversion.convertKana("ラ゚"), is("la"));
        assertThat(RomajiConversion.convertKana("リ゚"), is("li"));
        assertThat(RomajiConversion.convertKana("ル゚"), is("lu"));
        assertThat(RomajiConversion.convertKana("レ゚"), is("le"));
        assertThat(RomajiConversion.convertKana("ロ゚"), is("lo"));


        assertThat(RomajiConversion.convertKana("ウュ"), is("wyu"));
        assertThat(RomajiConversion.convertKana("ヴャ"), is("vya"));
        assertThat(RomajiConversion.convertKana("ヴュ"), is("vyu"));
        assertThat(RomajiConversion.convertKana("ヴョ"), is("vyo"));
        assertThat(RomajiConversion.convertKana("クヮ"), is("kwa"));
        assertThat(RomajiConversion.convertKana("グヮ"), is("gwa"));
        assertThat(RomajiConversion.convertKana("ツュ"), is("tsyu"));
//        assertThat(RomajiConversion.convertKana("トゥ"), is("tu"));
//        assertThat(RomajiConversion.convertKana("テュ"), is("tyu"));
//        assertThat(RomajiConversion.convertKana("ドゥ"), is("du"));
//        assertThat(RomajiConversion.convertKana("デュ"), is("dyu"));
        assertThat(RomajiConversion.convertKana("フャ"), is("fya"));
        assertThat(RomajiConversion.convertKana("フュ"), is("fyu"));
        assertThat(RomajiConversion.convertKana("フョ"), is("fyo"));
        assertThat(RomajiConversion.convertKana("リ゚ャ"), is("lya"));
        assertThat(RomajiConversion.convertKana("リ゚ュ"), is("lyu"));
        assertThat(RomajiConversion.convertKana("リ゚ェ"), is("lye"));
        assertThat(RomajiConversion.convertKana("リ゚ョ"), is("lyo"));
        assertThat(RomajiConversion.convertKana("ヷ"), is("va"));
        assertThat(RomajiConversion.convertKana("ヸ"), is("vi"));
        assertThat(RomajiConversion.convertKana("ヹ"), is("ve"));
        assertThat(RomajiConversion.convertKana("ヺ"), is("vo"));

        assertThat(RomajiConversion.convertKana("ローマじ"), is("rōmaji"));
        assertThat(RomajiConversion.convertKana("ふじさん"), is("fujisan"));
        assertThat(RomajiConversion.convertKana("おちゃ"), is("ocha"));
        assertThat(RomajiConversion.convertKana("ちじ"), is("chiji"));
        assertThat(RomajiConversion.convertKana("ちぢむ"), is("chijimu"));
        assertThat(RomajiConversion.convertKana("つづく"), is("tsuzuku"));

        assertThat(RomajiConversion.convertKana("ちょうおんぷ"), is("chōonpu"));
        assertThat(RomajiConversion.convertKana("ポッキー"), is("pokkī"));
        assertThat(RomajiConversion.convertKana("まって"), is("matte"));
        assertThat(RomajiConversion.convertKana("こっち"), is("kotchi"));

        assertThat(RomajiConversion.convertKana("おばあさん"), is("obāsan"));
        assertThat(RomajiConversion.convertKana("おにいさん"), is("oniisan"));
        assertThat(RomajiConversion.convertKana("おじいさん"), is("ojiisan"));
        assertThat(RomajiConversion.convertKana("おいしい"), is("oishii"));
        assertThat(RomajiConversion.convertKana("にいがた"), is("niigata"));
        assertThat(RomajiConversion.convertKana("はいいろ"), is("haiiro"));
        assertThat(RomajiConversion.convertKana("すうがく"), is("sūgaku"));
        assertThat(RomajiConversion.convertKana("ちゅうい"), is("chūi"));
        assertThat(RomajiConversion.convertKana("ぐうたら"), is("gūtara"));
        assertThat(RomajiConversion.convertKana("ゆううつ"), is("yūutsu"));
        assertThat(RomajiConversion.convertKana("おねえさん"), is("onēsan"));
        assertThat(RomajiConversion.convertKana("こおり"), is("kōri"));
        assertThat(RomajiConversion.convertKana("とおまわり"), is("tōmawari"));
        assertThat(RomajiConversion.convertKana("おおさか"), is("ōsaka"));
        assertThat(RomajiConversion.convertKana("がっこう"), is("gakkō"));
        assertThat(RomajiConversion.convertKana("とうきょう"), is("tōkyō"));
        assertThat(RomajiConversion.convertKana("べんきょう"), is("benkyō"));
        assertThat(RomajiConversion.convertKana("でんぽう"), is("denpō"));
        assertThat(RomajiConversion.convertKana("きんようび"), is("kin'yōbi"));
        assertThat(RomajiConversion.convertKana("こうし"), is("kōshi"));
        assertThat(RomajiConversion.convertKana("がくせい"), is("gakusei"));
        assertThat(RomajiConversion.convertKana("けいけん"), is("keiken"));
        assertThat(RomajiConversion.convertKana("せいふく"), is("seifuku"));
        assertThat(RomajiConversion.convertKana("めい"), is("mei"));
        assertThat(RomajiConversion.convertKana("まねいて"), is("maneite"));
        assertThat(RomajiConversion.convertKana("かるい"), is("karui"));
        assertThat(RomajiConversion.convertKana("うぐいす"), is("uguisu"));
        assertThat(RomajiConversion.convertKana("おい"), is("oi"));
        assertThat(RomajiConversion.convertKana("セーラー"), is("sērā"));
        assertThat(RomajiConversion.convertKana("パーティー"), is("pātī"));
        assertThat(RomajiConversion.convertKana("ヒーター"), is("hītā"));
        assertThat(RomajiConversion.convertKana("タクシー"), is("takushī"));
        assertThat(RomajiConversion.convertKana("スーパーマン"), is("sūpāman"));
        assertThat(RomajiConversion.convertKana("バレーボール"), is("barēbōru"));
        assertThat(RomajiConversion.convertKana("ソール"), is("sōru"));
        assertThat(RomajiConversion.convertKana("バレエ"), is("baree"));
        assertThat(RomajiConversion.convertKana("ソウル"), is("souru"));
        assertThat(RomajiConversion.convertKana("ミイラ"), is("miira"));
    }
}
