PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
-- review must be separate from daytrip to accomodate multiple reviews per daytrip
CREATE TABLE Daytrip (
	title varchar(100),
	date_trip Date,
	start_time Time,
	end_time Time,
	description varchar(1000),
	price int,
	photo varchar(50),
	available_seats int,
	location_name varchar(50),
	activity_name varchar(50),
	hotel_name varchar(120),
	PRIMARY KEY(title, date_trip, start_time),
	FOREIGN KEY(activity_name) REFERENCES Activity(name),
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name)
);
INSERT INTO Daytrip VALUES('Jöklaganga','2023-04-01','06:00:00','11:00:00','Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.',20999, null, 12, 'Suður', null, null);
INSERT INTO Daytrip VALUES('Jöklaganga','2023-04-04','13:00:00','18:00:00','Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.',20999, null, 12, 'Suður', null, null);
INSERT INTO Daytrip VALUES('Jöklaganga','2023-04-07','13:00:00','18:00:00','Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.',20999, null, 12, 'Suður', null, null);
INSERT INTO Daytrip VALUES('Jöklaganga','2023-04-10','13:00:00','18:00:00','Íslensku Jöklarnir eru einar af frægustu náttúruperlum þjóðar okkar, enda eru þeir svakalegt dæmi um hið svakalega afl sem náttúran hefur. Það eru fáar upplifanir jafn magnaðar og að fara í jöklagöngu. Þar færðu útsýni líkt engu öðru, endalaus snjór og ís í allar áttir, sólargeislarnir endarspeglaðir allstaðar frá. Á göngunni verður skoðað íshelli, sprungur, og allskyns aðra hluti. Leiðsögumaðurinn hefur gengið þar um í mörg, mörg ár og veit um allskyns leyndarmál falin í jöklinum. Matur er innifalinn í ferð. Til þess að koma með þarf góða gönguskó, hlýja úlpu, snjóbuxur, húfu, vettlinga, góðan bakpoka, og það er mælt með að fólk sé í góðu formi og reynslumikið í fjallgöngum.',20999, null, 12, 'Suður', null, null);
INSERT INTO Daytrip VALUES('Hekluganga','2023-04-01','06:00:00','11:00:00','Við vitum öll um hið hræðilega, tignarlega vald sem eldgos hafa. Óskiljanlegur kraftur liggur að baki þeirra, nægur kraftur til þess að eyðileggja heilar siðmenningar. Heklugos hafa ávallt verið svaðaleg og mögnuð, og því er tilvalið að skoða hana. Við bjóðum upp á skemmtilega og fræðandi göngu upp fjallið. Leiðsögumaðurinn er jarðfræðingur og veit endalausar staðreyndir um Heklu, eldgos og bergið sem þið munuð labba á. Mikilvægt er að hafa með góða gönguskó, hlýja úlpu, húfu og vettlinga, góðan göngu bakpoka og nesti.',15999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Hekluganga','2023-04-02','06:00:00','11:00:00','Við vitum öll um hið hræðilega, tignarlega vald sem eldgos hafa. Óskiljanlegur kraftur liggur að baki þeirra, nægur kraftur til þess að eyðileggja heilar siðmenningar. Heklugos hafa ávallt verið svaðaleg og mögnuð, og því er tilvalið að skoða hana. Við bjóðum upp á skemmtilega og fræðandi göngu upp fjallið. Leiðsögumaðurinn er jarðfræðingur og veit endalausar staðreyndir um Heklu, eldgos og bergið sem þið munuð labba á. Mikilvægt er að hafa með góða gönguskó, hlýja úlpu, húfu og vettlinga, góðan göngu bakpoka og nesti.',15999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Skoðunarferð á bóndabæ','2023-04-01','08:00:00','11:00:00','Dýr hafa fylgt mannkyninu í þúsundir ára, og munu fylgja okkur í þúsundir ára í viðbót. Því bjóðum við upp á ferð á bóndabæ þar sem er hægt að kíkja á öll fallegu dýrin okkar. Á þessum afar fagra, gamaldags bæ má finna beljur, svín, hænur, hana, hesta, kindur og geitur. Hægt verður að drekka mjólk beint frá kúnum, smakka fersk egg, fara á hestbak og auðvitað má klappa öllum dýrunum. Ef þú ert heppinn með tíma er jafnvel hægt að sjá sauðburðinn. Ekki er mælt með að mæta í fínum fötum, þar sem það er létt að skíta þau út. Innifalinn máltíð gerð einungis úr afurðum bæjarins.',10999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Skoðunarferð á bóndabæ','2023-04-02','08:00:00','11:00:00','Dýr hafa fylgt mannkyninu í þúsundir ára, og munu fylgja okkur í þúsundir ára í viðbót. Því bjóðum við upp á ferð á bóndabæ þar sem er hægt að kíkja á öll fallegu dýrin okkar. Á þessum afar fagra, gamaldags bæ má finna beljur, svín, hænur, hana, hesta, kindur og geitur. Hægt verður að drekka mjólk beint frá kúnum, smakka fersk egg, fara á hestbak og auðvitað má klappa öllum dýrunum. Ef þú ert heppinn með tíma er jafnvel hægt að sjá sauðburðinn. Ekki er mælt með að mæta í fínum fötum, þar sem það er létt að skíta þau út. Innifalinn máltíð gerð einungis úr afurðum bæjarins.',10999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Gönguferð undir stjörnuhimni','2023-04-01','19:00:00','23:00:00','Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.',6999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Gönguferð undir stjörnuhimni','2023-04-04','19:00:00','23:00:00','Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.',6999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Gönguferð undir stjörnuhimni','2023-04-07','19:00:00','23:00:00','Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.',6999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Gönguferð undir stjörnuhimni','2023-04-10','19:00:00','23:00:00','Stjörnurnar á himninum hafa áreiðanlega veitt hverju einasta skáldi, listamanni, söngvara og rithöfundi innblástur á einn hátt eða annan. Því bjóðum við nú upp á gistingu undir næturhimninum. Snemma um kvöldið verður gengið upp fjallshlíð þar sem við höfum fundið yndislegan stað þar sem hægt er að sofa undir berum himni. Um kvöldið verður kveikt varðeld þar sem við munum elda mat og spjalla, grilla sykurpúða, drekka kakó og syngja gömul íslensk lög saman. Þegar líður á kvöldið verður slökkt í varðeldinum og sérfræðingur okkar mun segja ykkur frá allskyns staðreyndum um stjörnurnar, stjörnumerkin, og hvernig áhrif næturhimininn hefur haft á samfélagið okkar. Mikilvægt er að taka með sér góðan bakpoka, hlýjan svefnpoka, ullarföt, kodda, vatnsbrúsa og jafnvel minniháttar nesti.',6999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Hvalaskoðun','2023-04-01','08:00:00','11:00:00','Ef það væri ekki fyrir sjávarafurðir okkar hefði siðmenning okkar fallið fyrir hundruðum ára. Ísland er þekkt fyrir að eyða miklum tíma í að veiða, en fátt í sjónum er jafn magnað og hvalirnir sem umkringja landið okkar. Núna bjóðum við upp á að fara með snekkju út á sjó og fá þá einstöku upplifun að sjá hval í sínu náttúrulega umhverfi. Um borð skipsins verður í boði ein máltíð, en það þarf að borga fyrir drykki sjálfur. Þetta er frábær upplifun ef þú vilt hafa fjör út á hafi og skoða náttúruna í leiðinni.',30999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Hvalaskoðun','2023-04-02','08:00:00','11:00:00','Ef það væri ekki fyrir sjávarafurðir okkar hefði siðmenning okkar fallið fyrir hundruðum ára. Ísland er þekkt fyrir að eyða miklum tíma í að veiða, en fátt í sjónum er jafn magnað og hvalirnir sem umkringja landið okkar. Núna bjóðum við upp á að fara með snekkju út á sjó og fá þá einstöku upplifun að sjá hval í sínu náttúrulega umhverfi. Um borð skipsins verður í boði ein máltíð, en það þarf að borga fyrir drykki sjálfur. Þetta er frábær upplifun ef þú vilt hafa fjör út á hafi og skoða náttúruna í leiðinni.',30999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-01','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-06','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-11','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-16','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-21','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Dagur Rjúpunnar','2023-04-26','08:00:00','16:00:00','Afar stór partur af íslenskri menningu eru rjúpna veiðar. Veiðimenn keyra út á rjúpnasvæði hundruðum talið, labba klukkutíman saman í snjó og kulda, og vonast eftir að finna bráð. Við bjóðum upp á dagsferð fyrir hópa af 2-4 þar sem mæting er 6 um morgun og þið verðið upp í fjalli til 10 um kvöldið. Leiðsögumaður okkar hefur veitt rjúpu í meira en fjörtíu ár og er því afar reynslumikill og góður veiðimaður. Hann mun leyfa ykkur öllum að reyna að skjóta rjúpu, og ef þið hittið megið þið skipta rjúpunum á milli ykkar. Afar mikilvægt er að vera í hlýjum fötum, góðum gönguskóm, hafa byssuleyfi og taka með sér gott og næringarríkt nesti.',49999, null, 12,'Norðvestur', null, null);
INSERT INTO Daytrip VALUES('Hellaskoðanir','2023-04-01','08:00:00','11:00:00','Þar sem Ísland er afar eldvirkt land, með magnaða sögu að baki sér hafa myndast hér allskyns hellar og furðuleg náttúruafbrigði. Í þessari ferð ætlum við að skoða allskyns hella upp á hálendi. Keyrt verður eins nálægt hellunum og við komumst, síðan verður gengið þar um og skoðað. Það verður jarðfræðingur með ykkur sem mun útskýra hvernig hellar myndast, sögulegt samhengi þeirra ásamt fullt af litlum fróðleiksmolum tengda hellunum. Sniðugt er að vera í góðum gönguskóm, fötum eftir veðri, taka með sér vatnsbrúsa og jafnvel lítið nesti.',17999, null, 12,'Norðaustur', null, null);
INSERT INTO Daytrip VALUES('Hellaskoðanir','2023-04-04','12:00:00','15:00:00','Þar sem Ísland er afar eldvirkt land, með magnaða sögu að baki sér hafa myndast hér allskyns hellar og furðuleg náttúruafbrigði. Í þessari ferð ætlum við að skoða allskyns hella upp á hálendi. Keyrt verður eins nálægt hellunum og við komumst, síðan verður gengið þar um og skoðað. Það verður jarðfræðingur með ykkur sem mun útskýra hvernig hellar myndast, sögulegt samhengi þeirra ásamt fullt af litlum fróðleiksmolum tengda hellunum. Sniðugt er að vera í góðum gönguskóm, fötum eftir veðri, taka með sér vatnsbrúsa og jafnvel lítið nesti.',17999, null, 12,'Norðaustur', null, null);
INSERT INTO Daytrip VALUES('Hellaskoðanir','2023-04-07','08:00:00','11:00:00','Þar sem Ísland er afar eldvirkt land, með magnaða sögu að baki sér hafa myndast hér allskyns hellar og furðuleg náttúruafbrigði. Í þessari ferð ætlum við að skoða allskyns hella upp á hálendi. Keyrt verður eins nálægt hellunum og við komumst, síðan verður gengið þar um og skoðað. Það verður jarðfræðingur með ykkur sem mun útskýra hvernig hellar myndast, sögulegt samhengi þeirra ásamt fullt af litlum fróðleiksmolum tengda hellunum. Sniðugt er að vera í góðum gönguskóm, fötum eftir veðri, taka með sér vatnsbrúsa og jafnvel lítið nesti.',17999, null, 12,'Norðaustur', null, null);
INSERT INTO Daytrip VALUES('Hellaskoðanir','2023-04-10','12:00:00','15:00:00','Þar sem Ísland er afar eldvirkt land, með magnaða sögu að baki sér hafa myndast hér allskyns hellar og furðuleg náttúruafbrigði. Í þessari ferð ætlum við að skoða allskyns hella upp á hálendi. Keyrt verður eins nálægt hellunum og við komumst, síðan verður gengið þar um og skoðað. Það verður jarðfræðingur með ykkur sem mun útskýra hvernig hellar myndast, sögulegt samhengi þeirra ásamt fullt af litlum fróðleiksmolum tengda hellunum. Sniðugt er að vera í góðum gönguskóm, fötum eftir veðri, taka með sér vatnsbrúsa og jafnvel lítið nesti.',17999, null, 12,'Norðaustur', null, null);
INSERT INTO Daytrip VALUES('Rútuferð um Gullna hringinn','2023-04-01','08:00:00','16:00:00','Þú hefur eflaust heyrt um gullna hringinn fræga. Í þessari ferð verður farið með rútu og keyrt allan gullna hringinn. Það verður stoppað hjá Þingvellum, Geysi, Gullfoss, Skálholt og ef tíminn er nægur verður jafnvel stoppað á nokkrum fleiri stöðum þar í kring. Þetta er frábær leið til þess að kynnast íslenskum náttúruperlum betur, og sjá hvað þetta land hefur upp á að bjóða. Mælt er með að vera í góðum göngskóm og klæða sig eftir veðri. Sniðugt væri að taka nesti og vatnsbrúsa með, þó það verði stoppað á veitingastað.',12999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Rútuferð um Gullna hringinn','2023-04-02','08:00:00','16:00:00','Þú hefur eflaust heyrt um gullna hringinn fræga. Í þessari ferð verður farið með rútu og keyrt allan gullna hringinn. Það verður stoppað hjá Þingvellum, Geysi, Gullfoss, Skálholt og ef tíminn er nægur verður jafnvel stoppað á nokkrum fleiri stöðum þar í kring. Þetta er frábær leið til þess að kynnast íslenskum náttúruperlum betur, og sjá hvað þetta land hefur upp á að bjóða. Mælt er með að vera í góðum göngskóm og klæða sig eftir veðri. Sniðugt væri að taka nesti og vatnsbrúsa með, þó það verði stoppað á veitingastað.',12999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Fræðiferð um Reykjavík','2023-04-01','08:00:00','13:00:00','Bæjarferð! Já, þú last rétt. Við bjóðum upp á að rölta um miðbæinn með sagnfræðingi sem getur gefið þér endalausan fróðleik um hvernig bærinn þróaðist, allskyns gamlar byggingar og auðkenni, og frægt fólk sem hefur búið þar í kring. Einstaklega sniðug ferð fyrir fólk sem hefur mikinn áhuga á sögu Reykjavíks. Í enda gögunnar verður farið á veitingastað þar sem verður ljómandi máltíð og síðan verður skellt í Kahoot um það sem þið hafið lært. Vinningur er í boði fyrir fyrsta sæti.',14999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Fræðiferð um Reykjavík','2023-04-02','08:00:00','13:00:00','Bæjarferð! Já, þú last rétt. Við bjóðum upp á að rölta um miðbæinn með sagnfræðingi sem getur gefið þér endalausan fróðleik um hvernig bærinn þróaðist, allskyns gamlar byggingar og auðkenni, og frægt fólk sem hefur búið þar í kring. Einstaklega sniðug ferð fyrir fólk sem hefur mikinn áhuga á sögu Reykjavíks. Í enda gögunnar verður farið á veitingastað þar sem verður ljómandi máltíð og síðan verður skellt í Kahoot um það sem þið hafið lært. Vinningur er í boði fyrir fyrsta sæti.',14999, null, 12,'Suðvestur', null, null);
INSERT INTO Daytrip VALUES('Ganga að Laugarfellslaug','2023-04-01','08:00:00','11:00:00','Fátt er jafn unaðslegt og löng ganga sem endar í afslöppuðu, hlýju baði. Keyrt verður upp að Fljótsdalshreðri og síðan gengið þaðan meðfram Laugará upp að Laugarfellslaug. Laugin er grafin í molldarkenndan jarðveg með veggi úr stóru, flötu grjóti. Hitastigið er um það bil 40 gráður og ágætis pláss í henni. Eftir að farið er í laugina verður rölt aftur að rútunni og keyrt heim. Sniðugt er að taka með góða gönguskó og klæðast vel þar sem þetta er á hálendi. Nauðsynlegt er að taka sundskýlu, handklæði og nesti.',18999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Ganga að Laugarfellslaug','2023-04-04','14:00:00','17:00:00','Fátt er jafn unaðslegt og löng ganga sem endar í afslöppuðu, hlýju baði. Keyrt verður upp að Fljótsdalshreðri og síðan gengið þaðan meðfram Laugará upp að Laugarfellslaug. Laugin er grafin í molldarkenndan jarðveg með veggi úr stóru, flötu grjóti. Hitastigið er um það bil 40 gráður og ágætis pláss í henni. Eftir að farið er í laugina verður rölt aftur að rútunni og keyrt heim. Sniðugt er að taka með góða gönguskó og klæðast vel þar sem þetta er á hálendi. Nauðsynlegt er að taka sundskýlu, handklæði og nesti.',18999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Ganga að Laugarfellslaug','2023-04-07','14:00:00','17:00:00','Fátt er jafn unaðslegt og löng ganga sem endar í afslöppuðu, hlýju baði. Keyrt verður upp að Fljótsdalshreðri og síðan gengið þaðan meðfram Laugará upp að Laugarfellslaug. Laugin er grafin í molldarkenndan jarðveg með veggi úr stóru, flötu grjóti. Hitastigið er um það bil 40 gráður og ágætis pláss í henni. Eftir að farið er í laugina verður rölt aftur að rútunni og keyrt heim. Sniðugt er að taka með góða gönguskó og klæðast vel þar sem þetta er á hálendi. Nauðsynlegt er að taka sundskýlu, handklæði og nesti.',18999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Ganga að Laugarfellslaug','2023-04-10','14:00:00','17:00:00','Fátt er jafn unaðslegt og löng ganga sem endar í afslöppuðu, hlýju baði. Keyrt verður upp að Fljótsdalshreðri og síðan gengið þaðan meðfram Laugará upp að Laugarfellslaug. Laugin er grafin í molldarkenndan jarðveg með veggi úr stóru, flötu grjóti. Hitastigið er um það bil 40 gráður og ágætis pláss í henni. Eftir að farið er í laugina verður rölt aftur að rútunni og keyrt heim. Sniðugt er að taka með góða gönguskó og klæðast vel þar sem þetta er á hálendi. Nauðsynlegt er að taka sundskýlu, handklæði og nesti.',18999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-01','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-06','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-11','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-16','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-21','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Dagsferð til Vestmannaeyja','2023-04-26','08:00:00','21:00:00','Allt landið tók andköf þegar heimaeyjargosið hófst. Enda er það líklegast það sem Heimaey er frægust fyrir, það eða þjóðhátíð. Núna bjóðum við upp á að kíkja í dagsferð til Heimaey. Þar er hægt að skoða bæjinn, fara í sund, labba í náttúrunni, kíkja í Herjólfsdal, og auðvitað smakka það sem heimamenn hafa upp á að bjóða. Það verður leiðsögumaður, en það er afar líklegt að hópurinn muni skiptast upp yfir daginn. Sniðugt að klæðast eftir veðri, taka með sér sundföt og smá nesti, og mjög mikilvægt að hafa á hreinu hvenær skipið kemur og fer.',23999, null, 12,'Suður', null, null);
INSERT INTO Daytrip VALUES('Skotsvæði','2023-04-01','08:00:00','16:00:00','Á íslandi eru um það bil þrjátíu byssur fyrir hverja hundruð íbúa, sem kemur kannski á óvart því Ísland er afar friðsælt land. Við höfum þó afar gaman af byssum, og því eru skotsvæði allstaðar um landið. Í þessari ferð verður farið með rútu að skotsvæði út á landi og eytt nokkrum tímum þar. Hægt er að skjóta með boga og allskyns riflum, og þar verður sérfræðingur sem getur kennt að miða betur. Börn yngri en 15 eru ekki leyfð.',8999, null, 12,'Norðaustur', null, null);
INSERT INTO Daytrip VALUES('Skotsvæði','2023-04-02','08:00:00','16:00:00','Á íslandi eru um það bil þrjátíu byssur fyrir hverja hundruð íbúa, sem kemur kannski á óvart því Ísland er afar friðsælt land. Við höfum þó afar gaman af byssum, og því eru skotsvæði allstaðar um landið. Í þessari ferð verður farið með rútu að skotsvæði út á landi og eytt nokkrum tímum þar. Hægt er að skjóta með boga og allskyns riflum, og þar verður sérfræðingur sem getur kennt að miða betur. Börn yngri en 15 eru ekki leyfð.',8999, null, 12,'Norðaustur', null, null);

CREATE TABLE Booking (
	num int(3), 
	booked_seats int,
	daytrip_title varchar(100),
	daytrip_date Date,
	daytrip_start_time Time,
	daytrip_end_time Time,
	daytrip_price int,
	hotel_name varchar(120),
	total_cost int,
	cust_id char(4),
	PRIMARY KEY(num)
	FOREIGN KEY(daytrip_title, daytrip_date, daytrip_start_time, daytrip_end_time, daytrip_price) REFERENCES Daytrip(title, date_trip, start_time, end_time, price)
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name)
);

CREATE TABLE Customer (
	id char(4) PRIMARY KEY,
	name varchar(100),
	email varchar(50),
	phone int,
	booking_number char(3),
	FOREIGN KEY (booking_number) REFERENCES Booking(num)
);

CREATE TABLE Review (
	num char(4) PRIMARY KEY,
	daytrip_title varchar(100),
	rating int(2),
	comment_text varchar(800),
	FOREIGN KEY(daytrip_title) REFERENCES Daytrip(title)
);
INSERT INTO Review VALUES('0000','Jöklaganga',10,'Þetta var ein flottasta ganga sem ég hef nokkurn tímann farið í. Veðrið var yndislegt, og ég hef sjaldan séð neitt jafn fagurt og endurspeglun ljóssins á víðtæka ísnum. Ég mæli eindregið með þessari upplifun.');
INSERT INTO Review VALUES('0001','Jöklaganga',5,'Þetta var svakalegt flott, en þetta var ofboðslega erfitt. Ég og eiginmaður minn gátum varla haldið í við leiðsögumanninn. Maturinn var heldur ekkert sérstakur. Mæli samt með þessu, þó að verðið sé kannski aðeins of hátt.');
INSERT INTO Review VALUES('0002','Jöklaganga',1,'Amma mín dróg mig með í þessa göngu og þetta var ömurlegt. Endalaus klaki og snjór, fokking ískalt, hræðilegur matur og alveg alltof erfitt. Skil ekkert í þessari þráhyggju um náttúru eða whatever.');
INSERT INTO Review VALUES('0003','Hekluganga',1,'sá ekkert eldgos, lame.');
INSERT INTO Review VALUES('0004','Hekluganga',8,'Frábær ganga, magnað útsýni en leiðsögumaðurinn var fremur dónalegur fyrir minn smekk.');
INSERT INTO Review VALUES('0005','Hekluganga',10,'Allt var fullkomið. Ég og unnusta mín skruppum í þessa ferð og áttum yndislega stund. Við erum afar forvitin um eldogs og fjöll, og leiðsögumaðurinn svaraði öllum spurningum okkar og sýndi okkur frábæra hluti. Við ætlum að kíkja aftur í sumar í betra veðri!');
INSERT INTO Review VALUES('0006','Skoðunarferð á bóndabæ',10,'Krakkarnir mínir elskuðu ferðina! Þau gátu eytt mörgum klukkutímum bara í að klappa dýrunum, hlaupa á fallegu engjunum og að sjálfsögðu var hápunktur ferðarinnar að fara á hestbak. Yndislega ljúf fjölskyldu ferð.');
INSERT INTO Review VALUES('0007','Gönguferð undir stjörnuhimni',9,'Þetta var frekar köld og óþægileg nótt, en hún var algjörlega þess virði. Þessi staðsetning er yndisleg og kósý, og það er svo stjörnubjart þarna! Við hlógum og sungum, og áttum frábæra stund.');
INSERT INTO Review VALUES('0008','Hvalaskoðun',8,'Þetta var mjög flott ferð, en drykkirnir voru fáranlega dýrir. Góður matur, fengum að sjá fullt af hvölum. Mæli með að fela áfengi inn á sér ef maður fer í þetta.');
INSERT INTO Review VALUES('0009','Dagur Rjúpunnar',5,'Við fundum bara fjórar rjúpur og bara einn af okkur hitti skotinu sínu. Ég hef enga hugmynd hvernig við erum að fara að skipta einni rjúpu á milli okkar. Annars var þetta bara fínt.');
INSERT INTO Review VALUES('0010','Hellaskoðanir',10,'Gaur, þetta var fucking epic. Ég hef aldrei skoðað svona helli áður en ég gat alveg svona öskrað og það bergmálaði og við félagarnir náðum alveg næstum því að villast! Fucking amazing 10/10');
INSERT INTO Review VALUES('0011','Rútuferð um Gullna hringinn',4,'Hver nennir að skoða náttúru þegar maður gæti spilað tölvuleiki?');
INSERT INTO Review VALUES('0012','Fræðiferð um Reykjavík',9,'Leiðsögumaður okkar var afar faglegur og virðist hafa endalausa þekkingu um bæjarlíf seinustu alda. Ég lærði heilmikið af nýjum staðreyndum um þessa fagra borg og get hreinlega sagt að þetta var yndisleg ferð.');
INSERT INTO Review VALUES('0013','Ganga að Laugarfellslaug',7,'Þetta var ágætis ganga og frábær laug með gullfallegu útsýni. Mér finnst verðið hinsvegar kjánalega hátt og mæli frekar með því að fara bara í þessa ferð á eigin bíl án leiðsögumanns.');
INSERT INTO Review VALUES('0014','Dagsferð til Vestmannaeyja',8,'Þetta var skemmtileg ferð og leiðsögumaðurinn hafði ansi margar tillögur um hluti til þess að skoða. Þegar leið á daginn fór mér samt að leiðast. Það er kannski aðeins og langur tími að vera heilan dag þarna.');
INSERT INTO Review VALUES('0015','Skotsvæði',10,'Það er ekkert sem jafnast á við það að skjóta byssu. Myndi gera það á hverjum einasta degi ef ég gæti.');
CREATE TABLE Activity (
	daytrip_title varchar(50),
	name varchar(50),
	PRIMARY KEY(daytrip_title, name),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
);
INSERT INTO Activity VALUES('Jöklaganga','Náttúra');
INSERT INTO Activity VALUES('Jöklaganga','ganga');
INSERT INTO Activity VALUES('Jöklaganga','matur');
INSERT INTO Activity VALUES('Jöklaganga','fræðandi');
INSERT INTO Activity VALUES('Hekluganga','Náttúra');
INSERT INTO Activity VALUES('Hekluganga','ganga');
INSERT INTO Activity VALUES('Hekluganga','fræðandi');
INSERT INTO Activity VALUES('Skoðunarferð á bóndabæ','Náttúra');
INSERT INTO Activity VALUES('Skoðunarferð á bóndabæ','fjör');
INSERT INTO Activity VALUES('Skoðunarferð á bóndabæ','matur');
INSERT INTO Activity VALUES('Skoðunarferð á bóndabæ','fjölskylduferð');
INSERT INTO Activity VALUES('Skoðunarferð á bóndabæ','fræðandi');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','Náttúra');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','ganga');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','fjör');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','matur');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','vinaferð');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','partý');
INSERT INTO Activity VALUES('Gönguferð undir stjörnuhimni','fræðandi');
INSERT INTO Activity VALUES('Hvalaskoðun','Náttúra');
INSERT INTO Activity VALUES('Hvalaskoðun','sjórinn');
INSERT INTO Activity VALUES('Hvalaskoðun','matur');
INSERT INTO Activity VALUES('Hvalaskoðun','fjölskylduferð');
INSERT INTO Activity VALUES('Hvalaskoðun','fræðandi');
INSERT INTO Activity VALUES('Dagur Rjúpunnar','Náttúra');
INSERT INTO Activity VALUES('Dagur Rjúpunnar','ganga');
INSERT INTO Activity VALUES('Dagur Rjúpunnar','fjör');
INSERT INTO Activity VALUES('Dagur Rjúpunnar','vinaferð');
INSERT INTO Activity VALUES('Hellaskoðanir','Náttúra');
INSERT INTO Activity VALUES('Hellaskoðanir','fjör');
INSERT INTO Activity VALUES('Hellaskoðanir','fjölskylduferð');
INSERT INTO Activity VALUES('Hellaskoðanir','vinaferð');
INSERT INTO Activity VALUES('Hellaskoðanir','fræðandi');
INSERT INTO Activity VALUES('Rútuferð um Gullna hringinn','Náttúra');
INSERT INTO Activity VALUES('Rútuferð um Gullna hringinn','matur');
INSERT INTO Activity VALUES('Rútuferð um Gullna hringinn','fjölskylduferð');
INSERT INTO Activity VALUES('Rútuferð um Gullna hringinn','fræðandi');
INSERT INTO Activity VALUES('Fræðiferð um Reykjavík','Ganga');
INSERT INTO Activity VALUES('Fræðiferð um Reykjavík','fjör');
INSERT INTO Activity VALUES('Fræðiferð um Reykjavík','matur');
INSERT INTO Activity VALUES('Fræðiferð um Reykjavík','vinaferð');
INSERT INTO Activity VALUES('Fræðiferð um Reykjavík','partý');
INSERT INTO Activity VALUES('Ganga að Laugarfellslaug','Náttúra');
INSERT INTO Activity VALUES('Ganga að Laugarfellslaug','ganga');
INSERT INTO Activity VALUES('Ganga að Laugarfellslaug','fjör');
INSERT INTO Activity VALUES('Ganga að Laugarfellslaug','vinaferð');
INSERT INTO Activity VALUES('Dagsferð til Vestmannaeyja','Náttúra');
INSERT INTO Activity VALUES('Dagsferð til Vestmannaeyja','sjórinn');
INSERT INTO Activity VALUES('Dagsferð til Vestmannaeyja','fjör');
INSERT INTO Activity VALUES('Dagsferð til Vestmannaeyja','fjölskylduferð');
INSERT INTO Activity VALUES('Dagsferð til Vestmannaeyja','vinaferð');
INSERT INTO Activity VALUES('Skotsvæði','Fjör');
INSERT INTO Activity VALUES('Skotsvæði','vinaferð');
INSERT INTO Activity VALUES('Skotsvæði','fræðandi');
CREATE TABLE Hotel (
	daytrip_title varchar(50),
	name varchar(120),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
);
INSERT INTO Hotel VALUES('Jöklaganga','Fosshotel Reykjavík');
INSERT INTO Hotel VALUES('Jöklaganga','Exeter Hotel');
INSERT INTO Hotel VALUES('Jöklaganga','Grand Hotel');
INSERT INTO Hotel VALUES('Hekluganga','Grand Hotel');
INSERT INTO Hotel VALUES('Hekluganga','Skuggi Hotel');
INSERT INTO Hotel VALUES('Hekluganga','Hotel Reykjavik Centrum');
INSERT INTO Hotel VALUES('Skoðunarferð á bóndabæ','Hotel Reykjavik Centrum');
INSERT INTO Hotel VALUES('Skoðunarferð á bóndabæ','Hotel Klettur');
INSERT INTO Hotel VALUES('Skoðunarferð á bóndabæ','Fosshotel Reykjavík');
INSERT INTO Hotel VALUES('Gönguferð undir stjörnuhimni','Hotel Borg');
INSERT INTO Hotel VALUES('Gönguferð undir stjörnuhimni','Grand Hotel');
INSERT INTO Hotel VALUES('Gönguferð undir stjörnuhimni','Hotel Klettur');
INSERT INTO Hotel VALUES('Hvalaskoðun','Hotel Klettur');
INSERT INTO Hotel VALUES('Hvalaskoðun','Hotel Oddsson');
INSERT INTO Hotel VALUES('Hvalaskoðun','Hotel Reykjavik Centrum');
INSERT INTO Hotel VALUES('Dagur Rjúpunnar','Eyja Guldsmeden Hotel');
INSERT INTO Hotel VALUES('Dagur Rjúpunnar','Reykjavik Lights');
INSERT INTO Hotel VALUES('Dagur Rjúpunnar','Hotel Klettur');
INSERT INTO Hotel VALUES('Hellaskoðanir','Skuggi Hotel');
INSERT INTO Hotel VALUES('Hellaskoðanir','Fosshotel Lind');
INSERT INTO Hotel VALUES('Hellaskoðanir','Hotel Oddsson');
INSERT INTO Hotel VALUES('Rútuferð um Gullna hringinn','Exeter Hotel');
INSERT INTO Hotel VALUES('Rútuferð um Gullna hringinn','Reykjavik Lights');
INSERT INTO Hotel VALUES('Rútuferð um Gullna hringinn','Skuggi Hotel');
INSERT INTO Hotel VALUES('Fræðiferð um Reykjavík','Hotel Oddsson');
INSERT INTO Hotel VALUES('Fræðiferð um Reykjavík','Fosshotel Reykjavík');
INSERT INTO Hotel VALUES('Fræðiferð um Reykjavík','Hotel Klettur');
INSERT INTO Hotel VALUES('Ganga að Laugarfellslaug','Fosshotel Lind');
INSERT INTO Hotel VALUES('Ganga að Laugarfellslaug','Exeter Hotel');
INSERT INTO Hotel VALUES('Ganga að Laugarfellslaug','Hotel Reykjavik Centrum');
INSERT INTO Hotel VALUES('Dagsferð til Vestmannaeyja','Eyja Guldsmeden Hotel');
INSERT INTO Hotel VALUES('Dagsferð til Vestmannaeyja','Hotel Reykjavik Centrum');
INSERT INTO Hotel VALUES('Dagsferð til Vestmannaeyja','Hotel Oddsson');
INSERT INTO Hotel VALUES('Skotsvæði','Grand Hotel');
INSERT INTO Hotel VALUES('Skotsvæði','Fosshotel Reykjavík');
INSERT INTO Hotel VALUES('Skotsvæði','Skuggi Hotel');
COMMIT;
PRAGMA foreign_keys=ON;