package org.mastodon.plugin.points;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Corrections
{
	public Corrections(final int ID)
	{
		switch (ID)
		{
			case 1:
				init01();
				break;
			case 2:
				init02();
				break;
			default:
		}
	}

	//data holder: time -> [[ x,y,z ]]
	HashMap<Integer, Vector<int[]>> corr = new HashMap<>(5);

	public
	int suggestZ(final int time, final int x, final int y)
	{
		if (corr.containsKey(time) == false) return -1;
		Vector<int[]> v = corr.get(time);

		for (int i=0; i < v.size(); ++i)
		if (v.get(i)[0] == x && v.get(i)[1] == y)
			return v.get(i)[2];

		return -1;
	}

	public
	Set<Integer> listTimePoints()
	{
		return corr.keySet();
	}

	public static void main(final String... args)
	{
		final Corrections c = new Corrections(1);
		System.out.println(c.suggestZ(4, 40, 20));
		System.out.println(c.suggestZ(31, 550, 1168));
	}

	//--------------- 01 ---------------
	private
	void init01()
	{
		Vector<int[]> v = new Vector<>(80);
		v.add(new int[] {979,679,4});
		v.add(new int[] {951,696,4});
		v.add(new int[] {962,773,4});
		v.add(new int[] {993,805,4});
		v.add(new int[] {971,839,4});
		v.add(new int[] {909,840,4});
		v.add(new int[] {939,914,4});
		v.add(new int[] {873,987,4});
		v.add(new int[] {801,1003,4});
		v.add(new int[] {777,1011,4});
		v.add(new int[] {807,1036,4});
		v.add(new int[] {783,1040,4});
		v.add(new int[] {730,1053,4});
		v.add(new int[] {626,1079,4});
		v.add(new int[] {737,1081,4});
		v.add(new int[] {652,1096,4});
		v.add(new int[] {707,1096,4});
		v.add(new int[] {609,1115,4});
		v.add(new int[] {659,1124,4});
		v.add(new int[] {566,1133,4});
		v.add(new int[] {605,1138,4});
		v.add(new int[] {509,1146,4});
		v.add(new int[] {544,1146,4});
		v.add(new int[] {482,1161,4});
		v.add(new int[] {621,1167,4});
		v.add(new int[] {563,1169,4});
		v.add(new int[] {455,1176,4});
		v.add(new int[] {508,1177,4});
		v.add(new int[] {431,1191,4});
		v.add(new int[] {482,1191,4});
		v.add(new int[] {517,1207,4});
		v.add(new int[] {405,1209,4});
		v.add(new int[] {459,1209,4});
		v.add(new int[] {434,1224,4});
		v.add(new int[] {471,1235,4});
		v.add(new int[] {421,1247,4});
		v.add(new int[] {371,1258,4});
		v.add(new int[] {399,1259,4});
		v.add(new int[] {458,1261,4});
		v.add(new int[] {434,1280,4});
		v.add(new int[] {405,1288,4});
		v.add(new int[] {360,1293,4});
		v.add(new int[] {348,1333,4});
		v.add(new int[] {326,1349,4});
		v.add(new int[] {308,1387,4});
		v.add(new int[] {334,1395,4});
		v.add(new int[] {354,1477,4});
		v.add(new int[] {322,1539,4});
		v.add(new int[] {329,1570,4});
		v.add(new int[] {359,1573,4});
		v.add(new int[] {329,1596,4});
		v.add(new int[] {355,1608,4});
		v.add(new int[] {369,1687,4});
		v.add(new int[] {419,1695,4});
		v.add(new int[] {393,1712,4});
		v.add(new int[] {422,1723,4});
		v.add(new int[] {417,1749,4});
		v.add(new int[] {476,1772,4});
		v.add(new int[] {421,1785,4});
		v.add(new int[] {424,1850,4});
		v.add(new int[] {450,1870,4});
		v.add(new int[] {409,1875,4});
		v.add(new int[] {422,1903,4});
		corr.put(21, v);

		v = new Vector<>(80);
		v.add(new int[] {971,674,4});
		v.add(new int[] {1004,678,4});
		v.add(new int[] {943,692,4});
		v.add(new int[] {954,728,4});
		v.add(new int[] {958,770,4});
		v.add(new int[] {991,798,4});
		v.add(new int[] {967,837,4});
		v.add(new int[] {928,863,4});
		v.add(new int[] {966,870,4});
		v.add(new int[] {878,959,4});
		v.add(new int[] {750,985,4});
		v.add(new int[] {866,985,4});
		v.add(new int[] {786,1001,4});
		v.add(new int[] {807,1016,4});
		v.add(new int[] {794,1037,4});
		v.add(new int[] {714,1055,4});
		v.add(new int[] {689,1063,4});
		v.add(new int[] {749,1067,4});
		v.add(new int[] {697,1099,4});
		v.add(new int[] {645,1104,4});
		v.add(new int[] {600,1118,4});
		v.add(new int[] {676,1119,4});
		v.add(new int[] {623,1132,4});
		v.add(new int[] {649,1132,4});
		v.add(new int[] {598,1141,4});
		v.add(new int[] {497,1144,4});
		v.add(new int[] {469,1152,4});
		v.add(new int[] {575,1165,4});
		v.add(new int[] {550,1168,4});
		v.add(new int[] {442,1170,4});
		v.add(new int[] {495,1170,4});
		v.add(new int[] {420,1183,4});
		v.add(new int[] {472,1183,4});
		v.add(new int[] {506,1196,4});
		v.add(new int[] {444,1202,4});
		v.add(new int[] {395,1203,4});
		v.add(new int[] {423,1218,4});
		v.add(new int[] {454,1231,4});
		v.add(new int[] {408,1244,4});
		v.add(new int[] {384,1251,4});
		v.add(new int[] {357,1256,4});
		v.add(new int[] {418,1275,4});
		v.add(new int[] {388,1285,4});
		v.add(new int[] {346,1290,4});
		v.add(new int[] {329,1332,4});
		v.add(new int[] {314,1356,4});
		v.add(new int[] {375,1368,4});
		v.add(new int[] {343,1369,4});
		v.add(new int[] {340,1462,4});
		v.add(new int[] {328,1595,4});
		v.add(new int[] {329,1635,4});
		v.add(new int[] {422,1652,4});
		v.add(new int[] {402,1669,4});
		v.add(new int[] {421,1723,4});
		v.add(new int[] {412,1755,4});
		v.add(new int[] {476,1774,4});
		corr.put(31, v);

		v = new Vector<>(80);
		v.add(new int[] {447,1275,6});
		v.add(new int[] {357,1302,6});
		v.add(new int[] {325,1502,6});
		v.add(new int[] {327,1530,6});
		v.add(new int[] {354,1548,6});
		v.add(new int[] {361,1600,6});
		v.add(new int[] {383,1602,6});
		v.add(new int[] {451,1697,6});
		corr.put(33, v);

		v = new Vector<>(80);
		v.add(new int[] {969,674,4});
		v.add(new int[] {939,693,4});
		v.add(new int[] {952,728,4});
		v.add(new int[] {954,770,4});
		v.add(new int[] {915,794,4});
		v.add(new int[] {989,799,4});
		v.add(new int[] {960,837,4});
		v.add(new int[] {923,864,4});
		v.add(new int[] {963,870,4});
		v.add(new int[] {907,890,4});
		v.add(new int[] {871,960,4});
		v.add(new int[] {745,983,4});
		v.add(new int[] {861,986,4});
		v.add(new int[] {780,999,4});
		v.add(new int[] {805,1014,4});
		v.add(new int[] {792,1034,4});
		v.add(new int[] {761,1036,4});
		v.add(new int[] {657,1050,4});
		v.add(new int[] {685,1066,4});
		v.add(new int[] {692,1104,4});
		v.add(new int[] {640,1106,4});
		v.add(new int[] {545,1121,4});
		v.add(new int[] {594,1121,4});
		v.add(new int[] {672,1124,4});
		v.add(new int[] {621,1132,4});
		v.add(new int[] {646,1136,4});
		v.add(new int[] {528,1142,4});
		v.add(new int[] {494,1143,4});
		v.add(new int[] {567,1144,4});
		v.add(new int[] {599,1144,4});
		v.add(new int[] {468,1152,4});
		v.add(new int[] {547,1167,4});
		v.add(new int[] {440,1168,4});
		v.add(new int[] {492,1171,4});
		v.add(new int[] {599,1171,4});
		v.add(new int[] {623,1177,4});
		v.add(new int[] {469,1183,4});
		v.add(new int[] {418,1185,4});
		v.add(new int[] {501,1195,4});
		v.add(new int[] {441,1201,4});
		v.add(new int[] {393,1204,4});
		v.add(new int[] {423,1220,4});
		v.add(new int[] {454,1229,4});
		v.add(new int[] {405,1242,4});
		v.add(new int[] {386,1256,4});
		v.add(new int[] {415,1273,4});
		v.add(new int[] {337,1292,4});
		v.add(new int[] {372,1368,4});
		v.add(new int[] {337,1467,4});
		v.add(new int[] {329,1635,4});
		v.add(new int[] {423,1654,4});
		v.add(new int[] {404,1668,4});
		v.add(new int[] {391,1713,4});
		v.add(new int[] {413,1753,4});
		v.add(new int[] {477,1773,4});
		corr.put(34, v);

		v = new Vector<>(80);
		v.add(new int[] {967,668,4});
		v.add(new int[] {938,690,4});
		v.add(new int[] {952,724,4});
		v.add(new int[] {982,749,4});
		v.add(new int[] {954,768,4});
		v.add(new int[] {912,791,4});
		v.add(new int[] {993,799,4});
		v.add(new int[] {961,833,4});
		v.add(new int[] {897,836,4});
		v.add(new int[] {920,859,4});
		v.add(new int[] {914,914,4});
		v.add(new int[] {870,952,4});
		v.add(new int[] {830,974,4});
		v.add(new int[] {885,981,4});
		v.add(new int[] {798,984,4});
		v.add(new int[] {774,996,4});
		v.add(new int[] {801,1009,4});
		v.add(new int[] {692,1031,4});
		v.add(new int[] {765,1033,4});
		v.add(new int[] {708,1058,4});
		v.add(new int[] {676,1066,4});
		v.add(new int[] {763,1068,4});
		v.add(new int[] {688,1104,4});
		v.add(new int[] {640,1105,4});
		v.add(new int[] {591,1122,4});
		v.add(new int[] {671,1123,4});
		v.add(new int[] {619,1133,4});
		v.add(new int[] {643,1135,4});
		v.add(new int[] {490,1143,4});
		v.add(new int[] {528,1143,4});
		v.add(new int[] {562,1143,4});
		v.add(new int[] {598,1147,4});
		v.add(new int[] {464,1150,4});
		v.add(new int[] {542,1169,4});
		v.add(new int[] {521,1170,4});
		v.add(new int[] {599,1171,4});
		v.add(new int[] {487,1174,4});
		v.add(new int[] {414,1183,4});
		v.add(new int[] {464,1184,4});
		v.add(new int[] {438,1200,4});
		v.add(new int[] {391,1207,4});
		v.add(new int[] {417,1222,4});
		v.add(new int[] {447,1231,4});
		v.add(new int[] {405,1248,4});
		v.add(new int[] {386,1259,4});
		v.add(new int[] {416,1277,4});
		v.add(new int[] {385,1291,4});
		v.add(new int[] {362,1343,4});
		v.add(new int[] {337,1459,4});
		v.add(new int[] {363,1485,4});
		v.add(new int[] {331,1524,4});
		v.add(new int[] {373,1630,4});
		v.add(new int[] {329,1633,4});
		v.add(new int[] {395,1651,4});
		v.add(new int[] {405,1667,4});
		v.add(new int[] {412,1756,4});
		v.add(new int[] {474,1775,4});
		v.add(new int[] {448,1834,4});
		corr.put(39, v);
	}

	//--------------- 02 ---------------
	private
	void init02()
	{
		Vector<int[]> v = new Vector<>(80);
		v.add(new int[] {622,868,10});
		v.add(new int[] {762,917,10});
		v.add(new int[] {735,926,10});
		v.add(new int[] {1174,1040,10});
		v.add(new int[] {1136,1055,10});
		v.add(new int[] {1223,1055,10});
		v.add(new int[] {1259,1078,10});
		v.add(new int[] {1139,1099,10});
		v.add(new int[] {1284,1104,10});
		v.add(new int[] {1265,1120,10});
		v.add(new int[] {1217,1144,10});
		v.add(new int[] {1266,1159,10});
		v.add(new int[] {1314,1174,10});
		v.add(new int[] {1354,1184,10});
		v.add(new int[] {1296,1188,10});
		v.add(new int[] {1364,1204,10});
		v.add(new int[] {1336,1211,10});
		v.add(new int[] {1293,1229,10});
		v.add(new int[] {1354,1229,10});
		v.add(new int[] {1322,1263,10});
		v.add(new int[] {1358,1283,10});
		v.add(new int[] {1339,1303,10});
		v.add(new int[] {1286,1321,10});
		v.add(new int[] {1320,1334,10});
		v.add(new int[] {1340,1345,10});
		v.add(new int[] {1306,1372,10});
		corr.put(105, v);

		v = new Vector<>(80);
		v.add(new int[] {642,828,10});
		v.add(new int[] {774,867,10});
		v.add(new int[] {744,876,10});
		v.add(new int[] {726,878,10});
		v.add(new int[] {800,927,10});
		v.add(new int[] {1008,955,10});
		v.add(new int[] {817,959,10});
		v.add(new int[] {1093,991,10});
		v.add(new int[] {1174,1032,10});
		v.add(new int[] {1124,1034,10});
		v.add(new int[] {1236,1045,10});
		v.add(new int[] {1067,1049,10});
		v.add(new int[] {1145,1058,10});
		v.add(new int[] {1276,1067,10});
		v.add(new int[] {1046,1082,10});
		v.add(new int[] {1142,1094,10});
		v.add(new int[] {1277,1122,10});
		v.add(new int[] {1222,1142,10});
		v.add(new int[] {1307,1169,10});
		v.add(new int[] {1478,1224,10});
		v.add(new int[] {1324,1228,10});
		v.add(new int[] {1423,1271,10});
		v.add(new int[] {1403,1386,10});
		v.add(new int[] {1361,1389,10});
		corr.put(154, v);

		v = new Vector<>(80);
		v.add(new int[] {317,354,12});
		v.add(new int[] {367,386,12});
		v.add(new int[] {303,387,12});
		v.add(new int[] {345,394,12});
		v.add(new int[] {386,401,12});
		v.add(new int[] {327,421,12});
		v.add(new int[] {361,424,12});
		v.add(new int[] {374,450,12});
		v.add(new int[] {324,456,12});
		v.add(new int[] {382,472,12});
		v.add(new int[] {299,473,12});
		v.add(new int[] {356,474,12});
		v.add(new int[] {387,490,12});
		v.add(new int[] {343,501,12});
		v.add(new int[] {373,503,12});
		v.add(new int[] {402,508,12});
		v.add(new int[] {291,519,12});
		v.add(new int[] {389,521,12});
		v.add(new int[] {368,529,12});
		v.add(new int[] {348,540,12});
		v.add(new int[] {324,541,12});
		v.add(new int[] {394,549,12});
		v.add(new int[] {340,569,12});
		v.add(new int[] {374,574,12});
		v.add(new int[] {311,578,12});
		v.add(new int[] {345,596,12});
		v.add(new int[] {292,598,12});
		v.add(new int[] {368,598,12});
		v.add(new int[] {365,623,12});
		v.add(new int[] {343,630,12});
		v.add(new int[] {322,633,12});
		v.add(new int[] {368,647,12});
		v.add(new int[] {367,668,12});
		v.add(new int[] {320,670,12});
		v.add(new int[] {408,674,12});
		v.add(new int[] {387,684,12});
		v.add(new int[] {357,688,12});
		v.add(new int[] {428,700,12});
		v.add(new int[] {389,705,12});
		v.add(new int[] {329,706,12});
		v.add(new int[] {406,717,12});
		v.add(new int[] {442,719,12});
		v.add(new int[] {459,721,12});
		v.add(new int[] {357,723,12});
		v.add(new int[] {424,723,12});
		v.add(new int[] {385,732,12});
		v.add(new int[] {453,744,12});
		v.add(new int[] {415,745,12});
		v.add(new int[] {471,746,12});
		v.add(new int[] {488,760,12});
		v.add(new int[] {434,762,12});
		v.add(new int[] {459,764,12});
		v.add(new int[] {491,776,12});
		v.add(new int[] {451,785,12});
		v.add(new int[] {424,790,12});
		v.add(new int[] {528,792,12});
		v.add(new int[] {510,794,12});
		v.add(new int[] {554,794,12});
		v.add(new int[] {578,797,12});
		v.add(new int[] {472,799,12});
		v.add(new int[] {493,799,12});
		v.add(new int[] {661,803,12});
		v.add(new int[] {448,812,12});
		v.add(new int[] {519,812,12});
		v.add(new int[] {603,812,12});
		v.add(new int[] {690,813,12});
		v.add(new int[] {542,814,12});
		v.add(new int[] {670,819,12});
		v.add(new int[] {499,820,12});
		v.add(new int[] {582,820,12});
		v.add(new int[] {724,828,12});
		v.add(new int[] {611,830,12});
		v.add(new int[] {705,830,12});
		v.add(new int[] {741,830,12});
		v.add(new int[] {554,831,12});
		v.add(new int[] {631,835,12});
		v.add(new int[] {650,836,12});
		v.add(new int[] {684,836,12});
		v.add(new int[] {471,837,12});
		v.add(new int[] {534,839,12});
		v.add(new int[] {591,840,12});
		v.add(new int[] {511,843,12});
		v.add(new int[] {665,848,12});
		v.add(new int[] {560,849,12});
		v.add(new int[] {699,856,12});
		v.add(new int[] {718,856,12});
		v.add(new int[] {615,857,12});
		v.add(new int[] {679,864,12});
		v.add(new int[] {852,868,12});
		v.add(new int[] {581,870,12});
		v.add(new int[] {779,871,12});
		v.add(new int[] {647,873,12});
		v.add(new int[] {802,873,12});
		v.add(new int[] {608,875,12});
		v.add(new int[] {925,876,12});
		v.add(new int[] {628,885,12});
		v.add(new int[] {555,887,12});
		v.add(new int[] {685,891,12});
		v.add(new int[] {874,891,12});
		v.add(new int[] {765,896,12});
		v.add(new int[] {796,896,12});
		v.add(new int[] {654,899,12});
		v.add(new int[] {836,899,12});
		v.add(new int[] {908,900,12});
		v.add(new int[] {709,901,12});
		v.add(new int[] {856,904,12});
		v.add(new int[] {936,905,12});
		v.add(new int[] {732,906,12});
		v.add(new int[] {885,923,12});
		v.add(new int[] {849,926,12});
		v.add(new int[] {753,936,12});
		v.add(new int[] {976,942,12});
		v.add(new int[] {927,943,12});
		v.add(new int[] {870,951,12});
		v.add(new int[] {1091,951,12});
		v.add(new int[] {852,958,12});
		v.add(new int[] {813,973,12});
		v.add(new int[] {841,986,12});
		v.add(new int[] {923,997,12});
		v.add(new int[] {1055,1013,12});
		v.add(new int[] {1029,1023,12});
		v.add(new int[] {1105,1047,12});
		v.add(new int[] {1103,1096,12});
		v.add(new int[] {1137,1123,12});
		v.add(new int[] {1387,1274,12});
		corr.put(161, v);

		v = new Vector<>(80);
		v.add(new int[] {1103,712,10});
		v.add(new int[] {868,715,10});
		v.add(new int[] {965,718,10});
		v.add(new int[] {707,720,10});
		v.add(new int[] {751,748,10});
		v.add(new int[] {845,755,10});
		v.add(new int[] {868,759,10});
		v.add(new int[] {1283,761,10});
		v.add(new int[] {1521,776,10});
		v.add(new int[] {753,791,10});
		v.add(new int[] {1585,791,10});
		v.add(new int[] {1544,798,10});
		v.add(new int[] {1509,799,10});
		v.add(new int[] {1279,827,10});
		v.add(new int[] {1440,893,10});
		corr.put(208, v);

		v = new Vector<>(80);
		v.add(new int[] {1588,588,10});
		v.add(new int[] {1528,623,10});
		v.add(new int[] {1162,640,10});
		v.add(new int[] {997,644,10});
		v.add(new int[] {1521,649,10});
		v.add(new int[] {899,659,10});
		v.add(new int[] {736,669,10});
		v.add(new int[] {886,691,10});
		v.add(new int[] {785,693,10});
		v.add(new int[] {1322,694,10});
		v.add(new int[] {773,714,10});
		v.add(new int[] {1469,725,10});
		v.add(new int[] {748,733,10});
		v.add(new int[] {1349,739,10});
		v.add(new int[] {1301,745,10});
		v.add(new int[] {786,749,10});
		v.add(new int[] {1509,750,10});
		v.add(new int[] {1571,750,10});
		corr.put(234, v);
	}
}
