package sample.Vinnsla;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockDatabaseManager implements IDatabaseManager{
    @Override
    public ObservableList<Daytrip> createDaytripObjects(ResultSet rs) throws SQLException {
        return null;
    }

    public void setUp() {
        Daytrip daytrip1 = new Daytrip("Jöklaganga","2023-04-01", "06:00:00", "11:00:00","Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.",20999, null, 12, null,"Suður", 4);
        Daytrip daytrip2 = new Daytrip("Gönguferð undir stjörnuhimni","2023-04-01","17:00:00","23:00:00","Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.",6999, null, 12, null,"Suðvestur", 7);
    }



}
