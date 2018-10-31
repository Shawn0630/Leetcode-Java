import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindLHSTest {

    FindLHS flhs;

    @Before
    public void setup() throws Exception {
        flhs = new FindLHS();
    }

    @Test
    public void test1() {
        assertEquals(5, flhs.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }

    @Test
    public void test2() {
        assertEquals(0, flhs.findLHS(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void test3() {
        assertEquals(4, flhs.findLHS(new int[]{1, 2, 2, 1}));
    }

    @Test
    public void test4() {
        assertEquals(4, flhs.findLHS(new int[]{0, 2, 2, 1, 1, 3}));
    }

    @Test
    public void test5() {
        assertEquals(2, flhs.findLHS(new int[]{47772,78785,46273,30033,69022,-49024,-14106,31893,-79662,15949,-56289,-41595,10954,24834,-64191,-84385,53024,41655,-95488,-62488,82066,-77052,90283,48269,-86851,-37915,-62115,8837,51873,-44513,59107,49104,1549,51379,25491,48519,15049,-23257,38313,62857,-10780,36142,14850,-34638,47641,74066,86264,39521,-68071,65581,-80682,80316,15265,12808,-27,-89753,-85592,-51822,-91743,-19110,-94463,-29338,22753,-81860,86927,-57609,51137,53791,24661,31439,23124,24490,-50184,46287,-36887,-56048,-99189,-3631,-59654,72889,-82227,-57795,17732,8514,71209,22093,42798,16344,-72296,-28959,83629,81546,-36953,71344,56186,91829,-68753,13024,50278,52896,81452,-27968,-37735,50879,68912,97506,-54604,-98090,-76170,-64191,77171,-12635,-12852,52469,18389,17243,-33061,63197,13838,86693,367,49788,-98802,65533,-2888,-87919,71292,17859,37045,-86096,-54779,34416,-5530,77674,-67443,48676,59985,96393,84606,96325,-16410,36096,88100,-47795,62921,71696,37755,-9942,-89403,-55556,38846,68217,97758,97849,23317,72352,-35931,31373,-89012,88949,54710,25538,97596,-34110,94129,3514,35361,18937,-93041,-83156,-71375,-76976,-18819,36631,65557,-37461,-57064,18567,70447,33977,89781,17431,-11077,75892,13637,-12206,-3672,4525,-85936,25683,-43659,-22527,37595,84629,351,70867,6919,-83946,56772,-47428,-14777,71555,-63280,89638,51863,-88705,-76918,26463,-34400,36266,-10441,94502,48609,95372,97713,8758,-50912,-92167,-66819,-53850,-39255,8642,25911,8885,42549,-61347,45833,-25529,54770,87129,63653,-70460,-24794,18870,40010,34549,11376,80355,69872,70550,77550,30580,3910,94946,66056,52781,53132,29986,5797,27324,36539,33021,58595,22812,-94138,-73855,19117,64077,12285,64427,90994,95331,6237,-39471,78814,63665,-80308,89126,41034,-52103,62980,29656,82678,-64012,-73964,84873,63121,28559,27955,31523,32526,-89573,-42127,29493,13497,-6682,92212,-96664,46064,51314,-8181,-78760,29947,-25923,74928,39332,17922,58260,34044,11037,17277,-84723,10184,94182,93436,82379,55599,75643,99231,48781,-78240,97991,75086,49351,135,-5555,79708,11517,46995,-25267,64370,-15800,40267,89282,90270,94130,14506,36756,-32254,21779,-32717,-83486,6959,92827,38765,57353,72066,4291,78151,61983,-52125,-25193,75246,90781,-63116,76393,-75737,-55069,14521,54212,10059,49476,-75559,23274,50786,33985,96573,96012,17545,54154,51611,56489,-85693,-75062,11319,89797,22033,-17100,-7078,-67168,54922,1951,95766,14725,46888,-62179,8814,52876,94291,-63304,52909,-98368,-65577,10901,85187,99147,44361,-40168,81783,68821,88763,3973,49390,-39766,86685,98046,94964,96068,2446,74714,-494,28035,39321,47561,42016,6018,-69606,12055,-62210,-45464,16179,-19422,8700,5130,35053,-64118,76048,94471,-50061,11543,-45998,96000,54894,81336,-333,-51308,84697,73637,17957,47696,68120,69484,15606,39068,-55303,-47370,46300,-99582,-71266,36148,83861,79792,-80882,36573,90111,-14824,-7622,71663,71068,42882,12075,72375,98702,83590,-31309,58991,52409,50187,46858,29601,65040,20365,37410,-82923,-95233,32352,-73148,48840,-46413,25079,-16911,-85445,-11450,-95026,7194,26594,50363,21459,8659,50450,49699,-8508,-21625,40747,-62482,61762,93742,80135,-52587,-62054,-281,33571,98075,54882,97966}));
    }
}
