package com.smms.service;



import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
/*
  public static List<Customer> getCustomers(List<Customer> list, int from, int to)
  {

    return list.subList(from, to);
  }

  public static Customer findById(List<Customer> list, int id)
  {

    for (Customer customer : list)
    {
      if (customer.getId() == id) return customer;
    }

    return null;
  }

  public static List<Customer> findNotById(List<Customer> list, int id, int from, int to)
  {
    List<Customer> sResult = new ArrayList<Customer>();

    for (Customer customer : list)
    {
      if (customer.getId() != id) sResult.add(customer);
    }

    return sResult.subList(from, to);
  }

  public static List<Customer> findGreaterAsId(List<Customer> list, int id, int from, int to)
  {
    List<Customer> sResult = new ArrayList<Customer>();

    for (Customer customer : list)
    {
      if (customer.getId() > id) sResult.add(customer);
    }

    return sResult.subList(from, to);
  }

  public static List<Customer> findLesserAsId(List<Customer> list, int id, int from, int to)
  {
    List<Customer> sResult = new ArrayList<Customer>();

    for (Customer customer : list)
    {
      if (customer.getId() < id) sResult.add(customer);
    }

    return sResult.subList(from, to);
  }

  public static Integer getCustomersCount(List<Customer> list)
  {

    return list.size();
  }

  public static List<Customer> buildList()
  {
    List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer(103, "Atelier graphique", "Schmitt", "Carine ", "40.32.2555", "54, rue Royale", "", "Nantes", "", "44000", "France", 1370, 21000.0));
    customers.add(new Customer(112, "Signal Gift Stores", "King", "Jean", "7025551838", "8489 Strong St.", "", "Las Vegas", "NV", "83030", "USA", 1166, 71800.0));
    customers.add(new Customer(114, "Australian Collectors, Co.", "Ferguson", "Peter", "03 9520 4555", "636 St Kilda Road", "Level 3", "Melbourne", "Victoria", "3004", "Australia", 1611, 117300.0));
    customers.add(new Customer(119, "La Rochelle Gifts", "Labrune", "Janine ", "40.67.8555", "67, rue des Cinquante Otages", "", "Nantes", "", "44000", "France", 1370, 118200.0));
    customers.add(new Customer(121, "Baane Mini Imports", "Bergulfsen", "Jonas ", "07-98 9555", "Erling Skakkes gate 78", "", "Stavern", "", "4110", "Norway", 1504, 81700.0));
    customers.add(new Customer(124, "Mini Gifts Distributors Ltd.", "Nelson", "Susan", "4155551450", "5677 Strong St.", "", "San Rafael", "CA", "97562", "USA", 1165, 210500.0));
    customers.add(new Customer(125, "Havel & Zbyszek Co", "Piestrzeniewicz", "Zbyszek ", "(26) 642-7555", "ul. Filtrowa 68", "", "Warszawa", "", "01-012", "Poland", 0, 0.0));
    customers.add(new Customer(128, "Blauer See Auto, Co.", "Keitel", "Roland", "+49 69 66 90 2555", "Lyonerstr. 34", "", "Frankfurt", "", "60528", "Germany", 1504, 59700.0));
    customers.add(new Customer(129, "Mini Wheels Co.", "Murphy", "Julie", "6505555787", "5557 North Pendale Street", "", "San Francisco", "CA", "94217", "USA", 1165, 64600.0));
    customers.add(new Customer(131, "Land of Toys Inc.", "Lee", "Kwai", "2125557818", "897 Long Airport Avenue", "", "NYC", "NY", "10022", "USA", 1323, 114900.0));
    customers.add(new Customer(141, "Euro+ Shopping Channel", "Freyre", "Diego ", "(91) 555 94 44", "C/ Moralzarzal, 86", "", "Madrid", "", "28034", "Spain", 1370, 227600.0));
    customers.add(new Customer(144, "Volvo Model Replicas, Co", "Berglund", "Christina ", "0921-12 3555", "Berguvsvägen  8", "", "Luleå", "", "S-958 22", "Sweden", 1504, 53100.0));
    customers.add(new Customer(145, "Danish Wholesale Imports", "Petersen", "Jytte ", "31 12 3555", "Vinbæltet 34", "", "Kobenhavn", "", "1734", "Denmark", 1401, 83400.0));
    customers.add(new Customer(146, "Saveley & Henriot, Co.", "Saveley", "Mary ", "78.32.5555", "2, rue du Commerce", "", "Lyon", "", "69004", "France", 1337, 123900.0));
    customers.add(new Customer(148, "Dragon Souveniers, Ltd.", "Natividad", "Eric", "+65 221 7555", "Bronz Sok.", "Bronz Apt. 3/6 Tesvikiye", "Singapore", "", "079903", "Singapore", 1621, 103800.0));
    customers.add(new Customer(151, "Muscle Machine Inc", "Young", "Jeff", "2125557413", "4092 Furth Circle", "Suite 400", "NYC", "NY", "10022", "USA", 1286, 138500.0));
    customers.add(new Customer(157, "Diecast Classics Inc.", "Leong", "Kelvin", "2155551555", "7586 Pompton St.", "", "Allentown", "PA", "70267", "USA", 1216, 100600.0));
    customers.add(new Customer(161, "Technics Stores Inc.", "Hashimoto", "Juri", "6505556809", "9408 Furth Circle", "", "Burlingame", "CA", "94217", "USA", 1165, 84600.0));
    customers.add(new Customer(166, "Handji Gifts& Co", "Victorino", "Wendy", "+65 224 1555", "106 Linden Road Sandown", "2nd Floor", "Singapore", "", "069045", "Singapore", 1612, 97900.0));
    customers.add(new Customer(167, "Herkku Gifts", "Oeztan", "Veysel", "+47 2267 3215", "Brehmen St. 121", "PR 334 Sentrum", "Bergen", "", "N 5804", "Norway  ", 1504, 96800.0));
    customers.add(new Customer(168, "American Souvenirs Inc", "Franco", "Keith", "2035557845", "149 Spinnaker Dr.", "Suite 101", "New Haven", "CT", "97823", "USA", 1286, 0.0));
    customers.add(new Customer(169, "Porto Imports Co.", "de Castro", "Isabel ", "(1) 356-5555", "Estrada da saúde n. 58", "", "Lisboa", "", "1756", "Portugal", 0, 0.0));
    customers.add(new Customer(171, "Daedalus Designs Imports", "Rancé", "Martine ", "20.16.1555", "184, chaussée de Tournai", "", "Lille", "", "59000", "France", 1370, 82900.0));
    customers.add(new Customer(172, "La Corne D'abondance, Co.", "Bertrand", "Marie", "(1) 42.34.2555", "265, boulevard Charonne", "", "Paris", "", "75012", "France", 1337, 84300.0));
    customers.add(new Customer(173, "Cambridge Collectables Co.", "Tseng", "Jerry", "6175555555", "4658 Baden Av.", "", "Cambridge", "MA", "51247", "USA", 1188, 43400.0));
    customers.add(new Customer(175, "Gift Depot Inc.", "King", "Julie", "2035552570", "25593 South Bay Ln.", "", "Bridgewater", "CT", "97562", "USA", 1323, 84300.0));
    customers.add(new Customer(177, "Osaka Souveniers Co.", "Kentary", "Mory", "+81 06 6342 5555", "1-6-20 Dojima", "", "Kita-ku", "Osaka", " 530-0003", "Japan", 1621, 81200.0));
    customers.add(new Customer(181, "Vitachrome Inc.", "Frick", "Michael", "2125551500", "2678 Kingston Rd.", "Suite 101", "NYC", "NY", "10022", "USA", 1286, 76400.0));
    customers.add(new Customer(186, "Toys of Finland, Co.", "Karttunen", "Matti", "90-224 8555", "Keskuskatu 45", "", "Helsinki", "", "21240", "Finland", 1501, 96500.0));
    customers.add(new Customer(187, "AV Stores, Co.", "Ashworth", "Rachel", "(171) 555-1555", "Fauntleroy Circus", "", "Manchester", "", "EC2 5NT", "UK", 1501, 136800.0));
    customers.add(new Customer(189, "Clover Collections, Co.", "Cassidy", "Dean", "+353 1862 1555", "25 Maiden Lane", "Floor No. 4", "Dublin", "", "2", "Ireland", 1504, 69400.0));
    customers.add(new Customer(198, "Auto-Moto Classics Inc.", "Taylor", "Leslie", "6175558428", "16780 Pompton St.", "", "Brickhaven", "MA", "58339", "USA", 1216, 23000.0));
    customers.add(new Customer(201, "UK Collectables, Ltd.", "Devon", "Elizabeth", "(171) 555-2282", "12, Berkeley Gardens Blvd", "", "Liverpool", "", "WX1 6LT", "UK", 1501, 92700.0));
    customers.add(new Customer(202, "Canadian Gift Exchange Network", "Tamuri", "Yoshi ", "(604) 555-3392", "1900 Oak St.", "", "Vancouver", "BC", "V3F 2K1", "Canada", 1323, 90300.0));
    customers.add(new Customer(204, "Online Mini Collectables", "Barajas", "Miguel", "6175557555", "7635 Spinnaker Dr.", "", "Brickhaven", "MA", "58339", "USA", 1188, 68700.0));
    customers.add(new Customer(205, "Toys4GrownUps.com", "Young", "Julie", "6265557265", "78934 Hillside Dr.", "", "Pasadena", "CA", "90003", "USA", 1166, 90700.0));
    customers.add(new Customer(206, "Asian Shopping Network, Co", "Walker", "Brydey", "+612 9411 1555", "Suntec Tower Three", "8 Temasek", "Singapore", "", "038988", "Singapore", 0, 0.0));
    customers.add(new Customer(209, "Mini Caravy", "Citeaux", "Frédérique ", "88.60.1555", "24, place Kléber", "", "Strasbourg", "", "67000", "France", 1370, 53800.0));
    customers.add(new Customer(211, "King Kong Collectables, Co.", "Gao", "Mike", "+852 2251 1555", "Bank of China Tower", "1 Garden Road", "Central Hong Kong", "", "", "Hong Kong", 1621, 58600.0));
    customers.add(new Customer(216, "Enaco Distributors", "Saavedra", "Eduardo ", "(93) 203 4555", "Rambla de Cataluña, 23", "", "Barcelona", "", "08022", "Spain", 1702, 60300.0));
    customers.add(new Customer(219, "Boards & Toys Co.", "Young", "Mary", "3105552373", "4097 Douglas Av.", "", "Glendale", "CA", "92561", "USA", 1166, 11000.0));
    customers.add(new Customer(223, "Natürlich Autos", "Kloss", "Horst ", "0372-555188", "Taucherstraße 10", "", "Cunewalde", "", "01307", "Germany", 0, 0.0));
    customers.add(new Customer(227, "Heintze Collectables", "Ibsen", "Palle", "86 21 3555", "Smagsloget 45", "", "Århus", "", "8200", "Denmark", 1401, 120800.0));
    customers.add(new Customer(233, "Québec Home Shopping Network", "Fresnière", "Jean ", "(514) 555-8054", "43 rue St. Laurent", "", "Montréal", "Québec", "H1J 1C3", "Canada", 1286, 48700.0));
    customers.add(new Customer(237, "ANG Resellers", "Camino", "Alejandra ", "(91) 745 6555", "Gran Vía, 1", "", "Madrid", "", "28001", "Spain", 0, 0.0));
    customers.add(new Customer(239, "Collectable Mini Designs Co.", "Thompson", "Valarie", "7605558146", "361 Furth Circle", "", "San Diego", "CA", "91217", "USA", 1166, 105000.0));
    customers.add(new Customer(240, "giftsbymail.co.uk", "Bennett", "Helen ", "(198) 555-8888", "Garden House", "Crowther Way 23", "Cowes", "Isle of Wight", "PO31 7PJ", "UK", 1501, 93900.0));
    customers.add(new Customer(242, "Alpha Cognac", "Roulet", "Annette ", "61.77.6555", "1 rue Alsace-Lorraine", "", "Toulouse", "", "31000", "France", 1370, 61100.0));
    customers.add(new Customer(247, "Messner Shopping Network", "Messner", "Renate ", "069-0555984", "Magazinweg 7", "", "Frankfurt", "", "60528", "Germany", 0, 0.0));
    customers.add(new Customer(249, "Amica Models & Co.", "Accorti", "Paolo ", "011-4988555", "Via Monte Bianco 34", "", "Torino", "", "10100", "Italy", 1401, 113000.0));
    customers.add(new Customer(250, "Lyon Souveniers", "Da Silva", "Daniel", "+33 1 46 62 7555", "27 rue du Colonel Pierre Avia", "", "Paris", "", "75508", "France", 1337, 68100.0));
    customers.add(new Customer(256, "Auto Associés & Cie.", "Tonini", "Daniel ", "30.59.8555", "67, avenue de l'Europe", "", "Versailles", "", "78000", "France", 1370, 77900.0));
    customers.add(new Customer(259, "Toms Spezialitäten, Ltd", "Pfalzheim", "Henriette ", "0221-5554327", "Mehrheimerstr. 369", "", "Köln", "", "50739", "Germany", 1504, 120400.0));
    customers.add(new Customer(260, "Royal Canadian Collectables, Ltd.", "Lincoln", "Elizabeth ", "(604) 555-4555", "23 Tsawassen Blvd.", "", "Tsawassen", "BC", "T2F 8M4", "Canada", 1323, 89600.0));
    customers.add(new Customer(273, "Franken Gifts, Co", "Franken", "Peter ", "089-0877555", "Berliner Platz 43", "", "München", "", "80805", "Germany", 0, 0.0));
    customers.add(new Customer(276, "Anna's Decorations, Ltd", "O'Hara", "Anna", "02 9936 8555", "201 Miller Street", "Level 15", "North Sydney", "NSW", "2060", "Australia", 1611, 107800.0));
    customers.add(new Customer(278, "Rovelli Gifts", "Rovelli", "Giovanni ", "035-640555", "Via Ludovico il Moro 22", "", "Bergamo", "", "24100", "Italy", 1401, 119600.0));
    customers.add(new Customer(282, "Souveniers And Things Co.", "Huxley", "Adrian", "+61 2 9495 8555", "Monitor Money Building", "815 Pacific Hwy", "Chatswood", "NSW", "2067", "Australia", 1611, 93300.0));
    customers.add(new Customer(286, "Marta's Replicas Co.", "Hernandez", "Marta", "6175558555", "39323 Spinnaker Dr.", "", "Cambridge", "MA", "51247", "USA", 1216, 123700.0));
    customers.add(new Customer(293, "BG&E Collectables", "Harrison", "Ed", "+41 26 425 50 01", "Rte des Arsenaux 41 ", "", "Fribourg", "", "1700", "Switzerland", 0, 0.0));
    customers.add(new Customer(298, "Vida Sport, Ltd", "Holz", "Mihael", "0897-034555", "Grenzacherweg 237", "", "Genève", "", "1203", "Switzerland", 1702, 141300.0));
    customers.add(new Customer(299, "Norway Gifts By Mail, Co.", "Klaeboe", "Jan", "+47 2212 1555", "Drammensveien 126A", "PB 211 Sentrum", "Oslo", "", "N 0106", "Norway  ", 1504, 95100.0));
    customers.add(new Customer(303, "Schuyler Imports", "Schuyler", "Bradley", "+31 20 491 9555", "Kingsfordweg 151", "", "Amsterdam", "", "1043 GR", "Netherlands", 0, 0.0));
    customers.add(new Customer(307, "Der Hund Imports", "Andersen", "Mel", "030-0074555", "Obere Str. 57", "", "Berlin", "", "12209", "Germany", 0, 0.0));
    customers.add(new Customer(311, "Oulu Toy Supplies, Inc.", "Koskitalo", "Pirkko", "981-443655", "Torikatu 38", "", "Oulu", "", "90110", "Finland", 1501, 90500.0));
    customers.add(new Customer(314, "Petit Auto", "Dewey", "Catherine ", "(02) 5554 67", "Rue Joseph-Bens 532", "", "Bruxelles", "", "B-1180", "Belgium", 1401, 79900.0));
    customers.add(new Customer(319, "Mini Classics", "Frick", "Steve", "9145554562", "3758 North Pendale Street", "", "White Plains", "NY", "24067", "USA", 1323, 102700.0));
    customers.add(new Customer(320, "Mini Creations Ltd.", "Huang", "Wing", "5085559555", "4575 Hillside Dr.", "", "New Bedford", "MA", "50553", "USA", 1188, 94500.0));
    customers.add(new Customer(321, "Corporate Gift Ideas Co.", "Brown", "Julie", "6505551386", "7734 Strong St.", "", "San Francisco", "CA", "94217", "USA", 1165, 105000.0));
    customers.add(new Customer(323, "Down Under Souveniers, Inc", "Graham", "Mike", "+64 9 312 5555", "162-164 Grafton Road", "Level 2", "Auckland", "", "", "New Zealand", 1612, 88000.0));
    customers.add(new Customer(324, "Stylish Desk Decors, Co.", "Brown", "Ann ", "(171) 555-0297", "35 King George", "", "London", "", "WX3 6FW", "UK", 1501, 77000.0));
    customers.add(new Customer(328, "Tekni Collectables Inc.", "Brown", "William", "2015559350", "7476 Moss Rd.", "", "Newark", "NJ", "94019", "USA", 1323, 43000.0));
    customers.add(new Customer(333, "Australian Gift Network, Co", "Calaghan", "Ben", "61-7-3844-6555", "31 Duncan St. West End", "", "South Brisbane", "Queensland", "4101", "Australia", 1611, 51600.0));
    customers.add(new Customer(334, "Suominen Souveniers", "Suominen", "Kalle", "+358 9 8045 555", "Software Engineering Center", "SEC Oy", "Espoo", "", "FIN-02271", "Finland", 1501, 98800.0));
    customers.add(new Customer(335, "Cramer Spezialitäten, Ltd", "Cramer", "Philip ", "0555-09555", "Maubelstr. 90", "", "Brandenburg", "", "14776", "Germany", 0, 0.0));
    customers.add(new Customer(339, "Classic Gift Ideas, Inc", "Cervantes", "Francisca", "2155554695", "782 First Street", "", "Philadelphia", "PA", "71270", "USA", 1188, 81100.0));
    customers.add(new Customer(344, "CAF Imports", "Fernandez", "Jesus", "+34 913 728 555", "Merchants House", "27-30 Merchant's Quay", "Madrid", "", "28023", "Spain", 1702, 59600.0));
    customers.add(new Customer(347, "Men 'R' US Retailers, Ltd.", "Chandler", "Brian", "2155554369", "6047 Douglas Av.", "", "Los Angeles", "CA", "91003", "USA", 1166, 57700.0));
    customers.add(new Customer(348, "Asian Treasures, Inc.", "McKenna", "Patricia ", "2967 555", "8 Johnstown Road", "", "Cork", "Co. Cork", "", "Ireland", 0, 0.0));
    customers.add(new Customer(350, "Marseille Mini Autos", "Lebihan", "Laurence ", "91.24.4555", "12, rue des Bouchers", "", "Marseille", "", "13008", "France", 1337, 65000.0));
    customers.add(new Customer(353, "Reims Collectables", "Henriot", "Paul ", "26.47.1555", "59 rue de l'Abbaye", "", "Reims", "", "51100", "France", 1337, 81100.0));
    customers.add(new Customer(356, "SAR Distributors, Co", "Kuger", "Armand", "+27 21 550 3555", "1250 Pretorius Street", "", "Hatfield", "Pretoria", "0028", "South Africa", 0, 0.0));
    customers.add(new Customer(357, "GiftsForHim.com", "MacKinlay", "Wales", "64-9-3763555", "199 Great North Road", "", "Auckland", "", "", "New Zealand", 1612, 77700.0));
    customers.add(new Customer(361, "Kommission Auto", "Josephs", "Karin", "0251-555259", "Luisenstr. 48", "", "Münster", "", "44087", "Germany", 0, 0.0));
    customers.add(new Customer(362, "Gifts4AllAges.com", "Yoshido", "Juri", "6175559555", "8616 Spinnaker Dr.", "", "Boston", "MA", "51003", "USA", 1216, 41900.0));
    customers.add(new Customer(363, "Online Diecast Creations Co.", "Young", "Dorothy", "6035558647", "2304 Long Airport Avenue", "", "Nashua", "NH", "62005", "USA", 1216, 114200.0));
    customers.add(new Customer(369, "Lisboa Souveniers, Inc", "Rodriguez", "Lino ", "(1) 354-2555", "Jardim das rosas n. 32", "", "Lisboa", "", "1675", "Portugal", 0, 0.0));
    customers.add(new Customer(376, "Precious Collectables", "Urs", "Braun", "0452-076555", "Hauptstr. 29", "", "Bern", "", "3012", "Switzerland", 1702, 0.0));
    customers.add(new Customer(379, "Collectables For Less Inc.", "Nelson", "Allen", "6175558555", "7825 Douglas Av.", "", "Brickhaven", "MA", "58339", "USA", 1188, 70700.0));
    customers.add(new Customer(381, "Royale Belge", "Cartrain", "Pascale ", "(071) 23 67 2555", "Boulevard Tirou, 255", "", "Charleroi", "", "B-6000", "Belgium", 1401, 23500.0));
    customers.add(new Customer(382, "Salzburg Collectables", "Pipps", "Georg ", "6562-9555", "Geislweg 14", "", "Salzburg", "", "5020", "Austria", 1401, 71700.0));
    customers.add(new Customer(385, "Cruz & Sons Co.", "Cruz", "Arnold", "+63 2 555 3587", "15 McCallum Street", "NatWest Center #13-03", "Makati City", "", "1227 MM", "Philippines", 1621, 81500.0));
    customers.add(new Customer(386, "L'ordine Souveniers", "Moroni", "Maurizio ", "0522-556555", "Strada Provinciale 124", "", "Reggio Emilia", "", "42100", "Italy", 1401, 121400.0));
    customers.add(new Customer(398, "Tokyo Collectables, Ltd", "Shimamura", "Akiko", "+81 3 3584 0555", "2-2-8 Roppongi", "", "Minato-ku", "Tokyo", "106-0032", "Japan", 1621, 94400.0));
    customers.add(new Customer(406, "Auto Canal+ Petit", "Perrier", "Dominique", "(1) 47.55.6555", "25, rue Lauriston", "", "Paris", "", "75016", "France", 1337, 95000.0));
    customers.add(new Customer(409, "Stuttgart Collectable Exchange", "Müller", "Rita ", "0711-555361", "Adenauerallee 900", "", "Stuttgart", "", "70563", "Germany", 0, 0.0));
    customers.add(new Customer(412, "Extreme Desk Decorations, Ltd", "McRoy", "Sarah", "04 499 9555", "101 Lambton Quay", "Level 11", "Wellington", "", "", "New Zealand", 1612, 86800.0));
    customers.add(new Customer(415, "Bavarian Collectables Imports, Co.", "Donnermeyer", "Michael", " +49 89 61 08 9555", "Hansastr. 15", "", "Munich", "", "80686", "Germany", 1504, 77000.0));
    customers.add(new Customer(424, "Classic Legends Inc.", "Hernandez", "Maria", "2125558493", "5905 Pompton St.", "Suite 750", "NYC", "NY", "10022", "USA", 1286, 67500.0));
    customers.add(new Customer(443, "Feuer Online Stores, Inc", "Feuer", "Alexander ", "0342-555176", "Heerstr. 22", "", "Leipzig", "", "04179", "Germany", 0, 0.0));
    customers.add(new Customer(447, "Gift Ideas Corp.", "Lewis", "Dan", "2035554407", "2440 Pompton St.", "", "Glendale", "CT", "97561", "USA", 1323, 49700.0));
    customers.add(new Customer(448, "Scandinavian Gift Ideas", "Larsson", "Martha", "0695-34 6555", "Åkergatan 24", "", "Bräcke", "", "S-844 67", "Sweden", 1504, 116400.0));
    customers.add(new Customer(450, "The Sharp Gifts Warehouse", "Frick", "Sue", "4085553659", "3086 Ingle Ln.", "", "San Jose", "CA", "94217", "USA", 1165, 77600.0));
    customers.add(new Customer(452, "Mini Auto Werke", "Mendel", "Roland ", "7675-3555", "Kirchgasse 6", "", "Graz", "", "8010", "Austria", 1401, 45300.0));
    customers.add(new Customer(455, "Super Scale Inc.", "Murphy", "Leslie", "2035559545", "567 North Pendale Street", "", "New Haven", "CT", "97823", "USA", 1286, 95400.0));
    customers.add(new Customer(456, "Microscale Inc.", "Choi", "Yu", "2125551957", "5290 North Pendale Street", "Suite 200", "NYC", "NY", "10022", "USA", 1286, 39800.0));
    customers.add(new Customer(458, "Corrida Auto Replicas, Ltd", "Sommer", "Martín ", "(91) 555 22 82", "C/ Araquil, 67", "", "Madrid", "", "28023", "Spain", 1702, 104600.0));
    customers.add(new Customer(459, "Warburg Exchange", "Ottlieb", "Sven ", "0241-039123", "Walserweg 21", "", "Aachen", "", "52066", "Germany", 0, 0.0));
    customers.add(new Customer(462, "FunGiftIdeas.com", "Benitez", "Violeta", "5085552555", "1785 First Street", "", "New Bedford", "MA", "50553", "USA", 1216, 85800.0));
    customers.add(new Customer(465, "Anton Designs, Ltd.", "Anton", "Carmen", "+34 913 728555", "c/ Gobelas, 19-1 Urb. La Florida", "", "Madrid", "", "28023", "Spain", 0, 0.0));
    customers.add(new Customer(471, "Australian Collectables, Ltd", "Clenahan", "Sean", "61-9-3844-6555", "7 Allen Street", "", "Glen Waverly", "Victoria", "3150", "Australia", 1611, 60300.0));
    customers.add(new Customer(473, "Frau da Collezione", "Ricotti", "Franco", "+39 022515555", "20093 Cologno Monzese", "Alessandro Volta 16", "Milan", "", "", "Italy", 1401, 34800.0));
    customers.add(new Customer(475, "West Coast Collectables Co.", "Thompson", "Steve", "3105553722", "3675 Furth Circle", "", "Burbank", "CA", "94019", "USA", 1166, 55400.0));
    customers.add(new Customer(477, "Mit Vergnügen & Co.", "Moos", "Hanna ", "0621-08555", "Forsterstr. 57", "", "Mannheim", "", "68306", "Germany", 0, 0.0));
    customers.add(new Customer(480, "Kremlin Collectables, Co.", "Semenov", "Alexander ", "+7 812 293 0521", "2 Pobedy Square", "", "Saint Petersburg", "", "196143", "Russia", 0, 0.0));
    customers.add(new Customer(481, "Raanan Stores, Inc", "Altagar,G M", "Raanan", "+ 972 9 959 8555", "3 Hagalim Blv.", "", "Herzlia", "", "47625", "Israel", 0, 0.0));
    customers.add(new Customer(484, "Iberia Gift Imports, Corp.", "Roel", "José Pedro ", "(95) 555 82 82", "C/ Romero, 33", "", "Sevilla", "", "41101", "Spain", 1702, 65700.0));
    customers.add(new Customer(486, "Motor Mint Distributors Inc.", "Salazar", "Rosa", "2155559857", "11328 Douglas Av.", "", "Philadelphia", "PA", "71270", "USA", 1323, 72600.0));
    customers.add(new Customer(487, "Signal Collectibles Ltd.", "Taylor", "Sue", "4155554312", "2793 Furth Circle", "", "Brisbane", "CA", "94217", "USA", 1165, 60300.0));
    customers.add(new Customer(489, "Double Decker Gift Stores, Ltd", "Smith", "Thomas ", "(171) 555-7555", "120 Hanover Sq.", "", "London", "", "WA1 1DP", "UK", 1501, 43300.0));
    customers.add(new Customer(495, "Diecast Collectables", "Franco", "Valarie", "6175552555", "6251 Ingle Ln.", "", "Boston", "MA", "51003", "USA", 1188, 85100.0));
    customers.add(new Customer(496, "Kelly's Gift Shop", "Snowden", "Tony", "+64 9 5555500", "Arenales 1938 3'A'", "", "Auckland  ", "", "", "New Zealand", 1612, 110000.0));
    return customers;
  }*/
}
