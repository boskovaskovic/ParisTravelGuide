package com.bvinstruments.paristravelguide.util;

import android.content.Context;

import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.sql.DBHandler;

public class DataLoader {

    public static void loadRestaurants(Context context){

        DBHandler handler=new DBHandler(context);
        handler.insertRestaurant(new Item("L’Arpège","Okay, it costs a freaking fortune (145 euros), but the vegetarian tasting menu by three-Michelin-starred chef Alain Passard is as close to nirvana as Paris can deliver for vegetarians. It’s so good that accompanying non-vegetarians will forget they came as a somewhat selfless gesture, too. Passard’s vegetables come from his own organic farm, and what you’ll get depends on what's available at the time. A sample of Passard’s talent with the bounty of the garden includes dishes like cep mushrooms with lemon and a vol au vent (puff pastry case) filled with baby peas, turnips, and snow peas in a sauce spiked with Cote du Jura wine. It’s worth pointing out that people have strong feelings about L’Arpège — the restaurant has its share of critics, including Eater’s own Ryan Sutton. [$$$$]\n" +
                "\n", R.drawable.arpege_facebook_0_0_0,0));
handler.insertRestaurant(new Item("Comice","The bulk of Paris’s famed haute cuisine is fiscally out of reach for many. However the year-old Comice, headed by Canadian chef Noam Gedalof and sommelier Etheliya Hananova (the two are married), is an indulgence that won’t completely melt your credit card. The look strikes a similar balance: elegant but relaxed, with striking arrangements from a renowned local florist. Hananova’s wine list — which features lesser-known wines from around the world — is terrific, as is Gedalof’s light, inventive contemporary French cooking. Try the duck foie gras with hazelnuts, strawberries, balsamic, and black pepper or the butter-poached lobster with sweet pea and mascarpone ravioli. [$$$]",R.drawable.comice,0));
handler.insertRestaurant(new Item("Hugo & Co","It’s been a while since an outstanding restaurant opened in the historic Latin Quarter, which is why Cambodian-born Tomy Gousset’s new place has been such a hit. Here, the chef — who spent time in the New York restaurant scene — preps a first-rate small-plates menu that will please both vegetarians and carnivores. Standout dishes include the savory pancake with guanciale; a breaded free-range pork cutlet with a fried egg, black rice, red cabbage, and curry sauce; and a black chocolate tart with puffed buckwheat and cappuccino ice cream. It’s an instant local favorite. [$$]",R.drawable.hugo_co,0));
handler.insertRestaurant(new Item("Détour","On a quiet side street in the heart of the city, not far from Pigalle, chef Adrien Cachot’s storefront bistro is one of the best buys in Paris right now. After working in a variety of top-notch kitchens, Cachot opened Detour, his first restaurant. Expect skilled contemporary French cooking and a frequently changing menu that consistently exhibits a well-edited creativity, as seen in dishes like cod with a soubise, mussel emulsion, and powdered grilled onions. Cachot’s beef heart, a piece of offal that’s suddenly a la mode in Paris, comes in fine slices with fromage blanc and harissa; it’s succulent and quietly funky. [$$]",R.drawable.paris_detour_0_0,0));
handler.insertRestaurant(new Item("L'Assiette","It is quiet, hard-working, limelight-shunning chefs like David Rathgeber who make Paris such an enduringly terrific food city. He took over this locally famous restaurant — previously helmed by a flamboyant chef named Lulu who charmed the likes of late President François Mitterrand and other celebrities — and has made it one of the city’s best bistros. It’s well worth the trek to the quiet 14th Arrondissement for his deft take on traditional dishes like pork-knuckle rillettes with foie gras and a superb cassoulet. The menu also offers lighter fare, including sea bream tartare with green tomato and coriander jus and cuttlefish carbonara. The creme caramel is nothing short of epic. [$$$]",R.drawable.lassiette,0));
handler.insertRestaurant(new Item("Oysters at l’Huîtrerie Régi","This minuscule, white-painted, no-reservations raw bar in the heart of Saint-Germain-des-Prés is a pearl, and it serves the best bivalves in Paris. The owner gets them shipped daily from the Marennes d’Oléron region on France’s Atlantic coast. Every customer is required to order at least a dozen oysters, which come with really good bread and excellent salted butter. [$$]",R.drawable.oysters_at_lhutrerie_rgi,0));
    }


    public static void loadEvents(Context context){

        DBHandler handler=new DBHandler(context);
        handler.insertEvent(new Item("Japonismes 2018  Paris in Japanese Colours","2018 marks the 160th anniversary of diplomatic relations between France and Japan, and the 150th anniversary of the Meiji period. For the occasion, Paris is organizing a series of events, exhibitions, and installations across the city, entitled 'Ames en résonances' (Souls in resonance). From the Eiffel Tower to the Domaine de Saint-Cloud, from La Villette to the Pompidou Centre, the Japanese spirit and some of the country's great cultural icons are shining bright in Paris!\n" + "from 01 July 2018 to 27 February 2019",R.drawable.japonesms,0));
handler.insertEvent(new Item("Les Dimanches au Galop (Sunday at the races)","This spring, the ‘Dimanches au Galop’ is back on track for a new edition.\n" +
        "\n" +"This family event, which takes place at the ParisLongchamp and Auteuil racecourses, offers free fun and sporty activities in a relaxed and festive atmosphere, for all ages in the heart of the world of horses.\n" +
        "\n" +"Each Sunday unveils a new theme. On the programme: pony rides, wooden horse merry-go-round, racing experience, ‘Jockey Potential’ championship, play area, horse racing.\n" +
        "\n",R.drawable.dimanches_galop,0));
handler.insertEvent(new Item("Paris Carnival Promenade du Boeuf Gras","The association 'A right to culture' has worked for many years to relaunch the Carnaval de Paris known as Saint-Fargeau.\n" +
        "It organizes a festive costumed parade through Paris led by Pimprenelle, a magnificent Limousin cow in a beautiful red dress. Pimprenelle is the mascot of the carnival  and leads the ‘promenade de boeuf gras’ in reference to a popular 16th-century  tradition.\n" +
        "This colourful and musical parade starts at Place Gambetta and finishes at the Place de la République.",R.drawable.tambour_fte_de_la_musique___630x405____otcp_amlie_dupont_i_175_26,0));
handler.insertEvent(new Item("Paris Fashion Week","Paris parades its finest creations in ready-to-wear on the occasion of Fashion Week. During this event, the new collections are presented at catwalk shows in the most beautiful places in the city.\n" +
        "\n" +"Courrèges, Lanvin, Iris Van Herpen, Christian Dior, Comme des Garçons, Stella McCartney or even Chanel, the biggest names take part in this event, making Paris Fashion Week one of the top events in the fashion world.\n" +
        "\n" +
        "Men's fashion (fall/winter 2019-2020): from 15 to 20 January 2019\n" +
        "Haute Couture (fall/winter2019-2020) : from 21 to 24 January 2019\n" +
        "Women's fashion (fall/winter 2019-2020) : from 25 February to 5 March 2019",R.drawable.fashion_week_podium___630x405____kris_atomic_via_unsplash,0));
handler.insertEvent(new Item("Sonic Protests","from 22 March 2019 to 06 April 2019\n" +
        "Paris et Île-de-France - 75 Paris\n" +
        "Since 2003, the Sonic Protest festival has been surprising audiences. Inviting an array of eclectic artists, the event takes place in venues across Paris and in the Paris region with a quality singular line-up including, a minimalist concert, sound installations, a documentary screening and workshops.",R.drawable.sonic_protest___630x405____sonic_protest,0));
handler.insertEvent(new Item("","For its 41th edition, the Cinéma du Réel festival returns to the Bibliothèque Publique d’Information with an ever unique and interesting line-up of films.\n" +
        "\n" +
        "Each year, the festival offers the general public and professionals a window on our world today via the screening of some 200 films. This amazingly diverse selection of documentaries is always very inspired and looks at our world with a special focus.\n" +
        "The event also features French and International competitions as well as a ‘First Films International Competition’ for new talented filmmakers.\n" +
        "\n" +
        "This not-to-miss event for all fans of cinema and documentaries takes place at the Centre Pompidou, the Centre Wallonie-Bruxelles, the Forum des images and the Luminor, as well as in cinemas in the Paris region.",R.drawable.cinma_du_rel___630x405____dr,0));


    }

    public static void loadHotels(Context context){
        DBHandler handler=new DBHandler(context);
        handler.insertHotel(new Item("Hotel Banke","This 5* property is housed in a former bank just steps from Paris Opéra Garnier and chic luxury shopping district. A perfection of discretion, its exterior whispers not a word of the opulence of its gilted interior decor and the original glass cupola that crowns the majestic lobby. The Madrid-based family who owns this Derby Collection of luxury hotels, are art aficionados. So, throughout the hotel you will find a priceless collection of historical jewelry artifacts from diverse cultures: Roman, Buddhist, pre-Columbian, Egyptian and African. The original mosaic-tiled floor and the ornate marble throughout the structure have been preserved during the renovation from bank to luxury hotel as has the authentic wooden-elevator. A spa with steamroom and sauna is available on the 2nd floor and breakfast served, with complimentary Cava, daily. Leather couches in superior suites, jacuzzi baths, complimentary wine all add that extra-bit. Restaurant and bar are also on-premise.",R.drawable.hotel_banke,0));
        handler.insertHotel(new Item("Hotel Fouquet's Barriere","A dedicated butler sees to your every whim, round-the-clock, from the moment you check-in. Amenities also include one of Paris's largest hotel swimming pools, which adjoins the one-of-a-kind Shiseido USpa. Upon arrival, children are gifted a treasure map to search for the hotel's mascot, a ladybug (which, everyone knows, brings good luck). Dignified Luxury. This term refers to Fouquet's Leading Green Certification ethics and its philosophy that the environment need not be abandoned in the quest for luxury. Step foot inside this historical icon located where the Avenue George V meets the Champs-Elysées and you would never guess that the sumptuous gold-and-velvet Jacques Garcia designs surrounding you are sustainably certified. Fouquet's is synonymous with French film stars. Each year the winners of the Cesar's, France's \"Oscar's\", are féted here with a gala dinner. But back in horse-and-buggy days, it was simply the chosen watering hole of the Champs-Elysées carriage drivers.",R.drawable.hotel_fouquets_barriere,0));
    handler.insertHotel(new Item("LA RESERVE PARIS HOTEL AND SPA","This is Paris' newest Palace hotel and one that stands fully apart from the others. When you're looking for a notch above 5-star, real luxury connoisseurs know to seek out a Parisian palace hotel. Until now, the properties in that class were all big, opulent, 100-room+ hotels. But La Reserve Hotel & Spa has now just changed all that. Opulent, yes, every inch. But it's also on the side of warm, cozy, boutique and ever so exclusive. The on-site restaurant is the restaurant awarded 2 Michelin stars this past year. And now with a new GM, famous among the world's VIP jetsetters for knowing them all on a first name basis, the property has that personal, je ne sais quoi French touch that's befitting of a Michel Reybier La Reserve property. Interior design is by Jacques Garcia and in addition to the bar and restaurant, the spa is top-shelf, too.\n",R.drawable.la_reserve_paris_hotel_and_spa,0));
    handler.insertHotel(new Item("Mandarin Oriental, Paris","East meets Europe at the Mandarin Oriental, Paris - one of the palace luxury hotels in Paris ideally situated from the city's best fashion houses on the rue Saint-Honore. 99 rooms and 39 suites are perfect for those seeking ample space, and a chic, modern style with an Oriental and Art Deco flair. Savor haute cusiine by Chef Thierry Marx (2*)at Sur Mesure or out on the inner courtyard terrace of Camelia for a memorable dining experience especially in the summer months. The sophisticated setting of Bar 8 is one of the most intimate places to enjoy refined cocktails. After browsing the streets of Paris, you can indulge at the tempting Cake Shop for some of the most delicious pastries in the city. The two-story spa, one of the largest in Paris, is a sanctuary complete with an inviting pool and outstanding signature treatments and spa therapies.",R.drawable.mandarin_oriental_paris,0));
    handler.insertHotel(new Item("Petit Moulin Hotel","Nestled in the trendy Marais district of Paris, nearPlace des Vosges Square, the New Boutique Hotel du Petit Moulin is a unique Paris venue. When booking a stay at the hip 4-star Paris Hotel signed by Christian Lacroix guests will be in the city of Paris. Picasso and Carnavalet museums, shops, restaurants, cafes and theaters of the vibrant 3rd arrondissement of Paris. Behind the historic facade of what used to be Paris' oldest bakery shop, the new fashionable Art Hotel du Petit Moulin is an inspirational collage of Old World charm and smart, eclectic interior design, offering world-class services and amenities in the heart of the City of Lights. Treat yourself to the charm and luxury of one of its 17 guest rooms, each one reflecting a specific aspect or period of the marsh district, altogether great, historic, hip and slightly decadent. An invitation to a journey, a journey in your Paris journey. And after a long day visiting Beaubourg or strolling along the Seine banks, come and unwind at the Bar, with genuine Parisian flair.",R.drawable.petit_moulin_hotel,0));



    }

    public static void loadCultures(Context context){

        DBHandler handler=new DBHandler(context);
        handler.insertCulture(new Item("Arc de Triomphe","Situated at the Place de l’Etoile, overlooking the Champs-Elysées, the Arc de Triomphe is the biggest arch in the world. It was commissioned by Napoleon in 1806 to celebrate his victory at Austerlitz. The architects Chalgrin, Joust and Blouet all worked on the monument. Sculptures were designed by Cortot, Rude, Etex, Pradier and Lemaire. Beneath the arch is the Tomb of the Unknown Soldier, and each evening at 6:30pm its flame is rekindled. From the top of the monument, visitors benefit from a panoramic view of Paris, during the day and at night, and two viewpoint indicators. A museum retracing the history of the Arc de Triomphe, situated within the structure, completes the visit.",R.drawable.arc_triomphe_36075_w800,0));
        handler.insertCulture(new Item("Conciergerie","This great vestige of the Capetian Palace is a remarkable testimony of the civil architecture of the 14th century with the Salle des Gens d'Armes, the Salle des Gardes and the kitchens.\n" +
                "Most of the lower floor of the Palace was turned into a prison during the 15th century: you can visit the dungeons (in particular Queen Marie-Antoinette's) and also discover memories of the French Revolution.",R.drawable.conciergerie_517fa280e5ce3,0));

handler.insertCulture(new Item("Eiffel Tower", "not-to-be-missed monument and symbol of the capital, the Eiffel Tower stands 324 m tall, and weighs 10,100 tons. Created in 2 years, 2 months and 5 days, it was built for the Exposition Universelle of 1889.\n" +
        "\n" +"You can go up the Eiffel Tower by the stairs or by lift. On the completely refurbished 1st floor, there are shops; on the 2nd, treat yourself to a gastronomic meal at the famous Jules Verne restaurant, 125 metres above ground. Finally on the 3rd floor you are at cloud level and have an exceptional 360° view! \n" +
        "Viewpoint indicator on the 3rd floor of the Eiffel Tower.\n" +"\n" + "Booking:\n" +        "- online on www.tour-eiffel.fr\n" +        "- by telephone: for individuals: +33 (0) 8 92 70 12 39, for groups: +33 (0) 8 92 70 00 16",R.drawable.eiffel,0));
handler.insertCulture(new Item("Opéra National de Paris - Palais Garnier","A 19th-century architectural masterpiece, the Palais Garnier Opera House, built by Charles Garnier and opened in 1875, is the 13th opera house in Paris since the introduction of French opera by Louis XIV in 1669. Napoleon III commissioned it as part of the renovation works in the capital carried out under his command by Baron Haussmann. A historical monument open to visitors during the day staging opera and dance. Don't forget to admire the ceiling painted by Chagall in the main auditorium.",R.drawable.opera_outside,0));
handler.insertCulture(new Item("Sainte-Chapelle","Situated on the Ile de la Cité, a short walk from Notre-Dame Cathedral, the Sainte-Chapelle chapel is a jewel of Gothic art. It was built in the 12th century, upon the order of King Saint-Louis, to house Christ’s Crown of Thorns, now held at Notre-Dame. The upper chapel of the monument is covered in 600 m² of stained-glass windows, of which two thirds are authentic. It’s one of the most complete and remarkable sets of stained glass of this era.",R.drawable.sainte_chapelle_4cd2e0fe6e1ef,0));
handler.insertCulture(new Item("Tours de Notre-Dame de Paris","After climbing the 422 steps of the towers of Notre-Dame cathedral, visitors are rewarded with one of the most stunning panoramic views of Paris. On the way up to the top are three not-to-be-missed features: The Salle Haute has amazing Gothic architecture with ribbed vaults; the Galerie des Chimères enables you to get close to the famous gargoyles, including the famous Stryge; and a few steps from the top, you can stop and admire the belfry, church bells and the famous 13-ton great bell 'Emmanuel'.",R.drawable.tours_de_notre_dame_de_paris,0));
    }

}