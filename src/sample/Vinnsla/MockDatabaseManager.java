package sample.Vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.Vidmot.DaytripController;

import java.text.ParseException;

import static org.junit.Assert.*;

public class MockDatabaseManager implements IDatabaseManager{
    private ObservableList<Daytrip> daytrips = FXCollections.observableArrayList();
    private DaytripController dtController = new DaytripController();


    @Before
    public void setUp() {
        Daytrip daytrip1 = new Daytrip("Jöklaganga","2023-04-01", "06:00:00", "11:00:00","Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.",20999, null, 12, "Suður",null, 4);
        Daytrip daytrip2 = new Daytrip("Gönguferð undir stjörnuhimni","2023-04-01","17:00:00","23:00:00","Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.",6999, null, 12, "Suðvestur",null, 7);
        Daytrip daytrip3 = new Daytrip("Dagur Rjúpunnar","2023-04-01","08:00:00","16:00:00","Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.",49999, null, 12, "Norðvestur",null, 8);
        Daytrip daytrip4 = new Daytrip("Hellaskoðanir","2023-04-01","08:00:00","11:00:00","Þar sem Ísland er afar eldvirkt land, með magnaða sögu að baki sér hafa myndast hér allskyns hellar og furðuleg náttúruafbrigði. Í þessari ferð ætlum við að skoða allskyns hella upp á hálendi. Keyrt verður eins nálægt hellunum og við komumst, síðan verður gengið þar um og skoðað. Það verður jarðfræðingur með ykkur sem mun útskýra hvernig hellar myndast, sögulegt samhengi þeirra ásamt fullt af litlum fróðleiksmolum tengda hellunum. Sniðugt er að vera í góðum gönguskóm, fötum eftir veðri, taka með sér vatnsbrúsa og jafnvel lítið nesti.",17999, null, 12, "Norðaustur",null, 3);
        daytrips.add(daytrip1);
        daytrips.add(daytrip2);
        daytrips.add(daytrip3);
        daytrips.add(daytrip4);
    }
    @After
    public void tearDown(){
        daytrips = null;
    }
    @Test
    public void testSortingByRating() {
        ObservableList<Daytrip> sortedByRating =dtController.sortByRating(daytrips, true);
        assertNotNull(sortedByRating);
        sortedByRating.forEach((Daytrip)->System.out.println(Daytrip.getTitle()+" "+Daytrip.getRating()));
    }
    @Test
    public void testFilterByLocation() throws ParseException {
        String searchQuery = "Suður";
        ObservableList<Daytrip> filteredByLocation = dtController.filterByLocation(daytrips,searchQuery);
        assertNotNull(filteredByLocation);
        filteredByLocation.forEach((Daytrip)->assertEquals(searchQuery, Daytrip.getLocation()));
        filteredByLocation.forEach((Daytrip)->System.out.println(Daytrip.getTitle()+" "+Daytrip.getLocation()));
    }
}