-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2019 at 02:47 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `title` varchar(50) DEFAULT NULL,
  `bookid` int(11) NOT NULL,
  `author` varchar(50) NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`title`, `bookid`, `author`, `description`) VALUES
('Vrli Novi Svijet', 1, 'Aldous Haxley', NULL),
('Pri?e o Obi?nom Ludilu', 2, 'Charles Bukowski', ''),
('Digitalna Tvrdjava', 3, 'Dan Brown', 'Vrhunska šifra je mo?na, opasna – i nerešiva...Kada je nepobediva mašina za dešifrovanje Agencije za nacionalnu bezbednost naišla na tajanstveni kod koji nije mogla da reši, Agencija je pozvala svog glavnog kriptografa, Suzan Fle?er – genijalnu, prelepu matemati?arku. Njeno otkri?e potresa sam vrh vlasti. Agencija za nacionalnu bezbednost postaje talac... i to ne talac kojem se preti pištoljima i bombama, ve? kodom koji je toliko genijalno složen da bi njegovo obelodanjivanje i puštanje u opticaj uništilo ameri?ku obaveštajnu službu. Zarobljena u vrtlogu tajni i laži, Suzan Fle?er se bori da spase agenciju u koju veruje. Kada shvati da su je svi izdali, otkriva da se bori ne samo za sopstvenu zemlju, nego i za sopstveni život, i naposletku, za život ?oveka kojeg voli.'),
('Stepski Vuk', 4, 'Herman Hesse', 'A ono što se u meni dogada u rijetkim casovima radosti, što je za mene slast, doživljaj, ekstaza i uzvišenost, to svijet voli i traži možda jedino u pjesnickim djelima, a u životu smatra ludošcu. I odista, ako je svijet u pravu, ako su ta muzika po kafanama, te masovne zabave, ti amerikanizovani ljudi, zadovoljni tako sitnim stvarima, u pravu su, onda sam ja kriv, onda sam lud, onda sam odista, kako sam sebe cesto nazivao, stepski vuk, životinja koja je zalutala u tud i nerazumljiv svijet koja više ne nalazi svoju postojbinu, vazduh i hranu'),
('Vrata Percepcije, Pakao i Raj', 5, 'Aldous Huxley', 'Ako se vrata percepcije prociste, Sve ce pred covjekom biti kakvo jest, beskrajno.'),
('Zlocin i Kazna', 6, 'Fjordor Mihajlovic Dostojevski', 'Zlo?in i kazna” je najpoznatiji i naj?itaniji roman F. M. Dostojevskog kojim je stekao svoju slavu. Dostojevski u romanu Zlo?in i kazna dijeli istu temu, grijeha i iskupljenja kao i u svojim romanima Idiot i Bra?a Karamazovi dok je Silvije Strahimir Kranj?evi? u svojoj pjesmi Vizija spomenuo Rodiona Romanovi?a Raskoljnjikova, glavnog lika ovog romana, te ga je iz lika ubojice plemenitih ciljeva pretvorio u lika revolucionara.'),
('Idiot', 7, 'Fjodor Mihajlovic Dostojevski', '"Svaka ruska nezgoda i neda?a izaziva u njega smijeh, samo što ga ne ushi?uje. On mrzi narodne obi?aje, rusku historiju, sve. Tu kivnost na Rusiju neki su naši liberali, sve donedavno, smatrali, tako re?i, pravom ljubavlju prema domovini i di?ili se time kako tobože vide bolje od drugih kakva treba da bude ta ljubav; ali sad su ve? postali otvoreniji pa su se po?eli stidjeti ?ak i rije?i ljubav prema domovini, ?ak su i sam taj pojam protjerali i izbacili kao nešto štetno i bezvrijedno."'),
('S one Strane Dobra i Zla', 8, 'Frederik Nietzsche', 'Gotovo sve što zovemo višom kulturom po?iva na produhovljenju i produbljenju okrutnosti. Ona divlja životinja uop?e nije umrtvljena. Ona živi, cvate, samo se - obogotvorila. Ono što ?ini bolnu nasladu tragedije je okrutnost. Postoji obilan, preobilan užitak i u vlastitoj patnji, u vlastitom ?injenju sebe pate?im.'),
('Gospodjica', 9, 'Ivo Andric', ''),
('Prokleta Avlija', 10, 'Ivo Andric', '"Mi smo uvijek manje ili više skloni da osudimo one koji mnogo govore, naro?ito o stvarima koje ih se ne ti?u neposredno, ?ak i da sa prezirom govorimo o tim ljudima kao o brbljivcima i dosadnim pri?alicama. A pri tome ne mislimo da ta ljudska, toliko ljudska i tako ?esta mana ima i svoje dobre strane. Jer, šta bismo mi znali o tu?im dušama i mislima, o drugim ljudima, pa prema tome i o sebi, o drugim sredinama i predjelima koje nismo nikad vidjeli niti ?emo imati prilike da ih vidimo, da nema takvih ljudi koji imaju potrebu da usmeno ili pismeno kazuju ono što su vidjeli i ?uli, i što su s tim u vezi doživjeli ili mislili?"'),
('Tvrdjava', 11, 'Mesa Selimovic', '"Mogu da mislim šta god ho?u, u?initi ne mogu ništa. U današnjem svijetu ostaju nam samo dvije mogu?nosti, prilago?avanje ili vlastita žrtva. Boriti se ne možeš, kad bi i htio, onemogu?i?e te na prvom koraku, pri prvoj rije?i, i to je samoubistvo, bez dejstva, bez smisla, bez imena i uspomena. Nemaš mogu?nosti da kažes ono što ti je na srcu, pa da poslije i stradaš! Premlati?e te da ne progovoriš, da iza tebe ostane sramota ili ?utanje."'),
('Mracna Kula', 12, 'Steven King', 'Krenite u osvajanje Mra?ne kule i zakora?ite u ovaj briljantan serijal u kojem King upoznaje ?itaoce sa jednim od svojih najzagonetnijih heroja, Rolandom od Gileada, poslednjim revolverašem, lovcem i usamljenikom na neverovatnom putovanju kroz dobro i zlo.Pun zapanjuju?e slikovitih detalja i nezaboravnih likova, serijal Mra?na kula nešto je što nikada do sada niste pro?itali. Sa vizionarskog aspekta, ovo je najbolje delo Stivena Kinga, magi?na kombinacija fantazije i horora koji zajedni?ki dostižu vrhunac uzbu?enja i ostavljaju ?itaoce bez daha.');

-- --------------------------------------------------------

--
-- Table structure for table `books_issued`
--

CREATE TABLE IF NOT EXISTS `books_issued` (
  `bookid` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books_issued`
--

INSERT INTO `books_issued` (`bookid`, `title`, `name`) VALUES
(3, 'Digitalna Tvrdjava', 'Sejla Jahic'),
(3, 'Digitalna Tvrdjava', 'Sejla Jahic'),
(3, 'Digitalna Tvrdjava', 'Sejla Jahic'),
(2, 'Pri?e o Obi?nom Ludilu', 'Emina Kocic'),
(4, 'Stepski Vuk', 'Jasmin Kocic'),
(5, 'Vrata Percepcije, Pakao i Raj', 'Emina Kocic'),
(12, 'Mracna Kula', 'Selma Kocic'),
(6, 'Zlocin i Kazna', 'Majda Gazetic'),
(6, 'Zlocin i Kazna', 'Adna Imamovic');

-- --------------------------------------------------------

--
-- Stand-in structure for view `issuedbook`
--
CREATE TABLE IF NOT EXISTS `issuedbook` (
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `issuedbooks`
--
CREATE TABLE IF NOT EXISTS `issuedbooks` (
);
-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username1` varchar(12) NOT NULL,
  `password1` varchar(12) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username1`, `password1`, `id`) VALUES
('admin', '123456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `name` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`name`, `id`, `number`, `email`) VALUES
('Emina Kocic', 1, 61937979, 'emina@gmail.com'),
('Selma Kocic', 2, 61584160, 'selma123@hotmail.com'),
('Sejla Jahic', 3, 61999555, 'sejla123@gmail.com'),
('Mirela Kocic', 4, 61331474, 'mirela12@hotmail.com'),
('Jasmin Kocic', 5, 61331474, 'jasmin@gmail.com'),
('Adna Imamovic', 6, 61331191, 'adna.i@hotmail.com'),
('Azra Jahic', 7, 61778922, 'azra.jahic@gmail.com'),
('Eldin Delic', 8, 61778932, 'eldin@gmail.com'),
('Majda Gazetic', 10, 61999225, 'maja1301@yahoo.com');

-- --------------------------------------------------------

--
-- Structure for view `issuedbook`
--
DROP TABLE IF EXISTS `issuedbook`;
-- in use(#1356 - View 'library.issuedbook' references invalid table(s) or column(s) or function(s) or definer/invoker of view lack rights to use them)

-- --------------------------------------------------------

--
-- Structure for view `issuedbooks`
--
DROP TABLE IF EXISTS `issuedbooks`;
-- in use(#1356 - View 'library.issuedbooks' references invalid table(s) or column(s) or function(s) or definer/invoker of view lack rights to use them)

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
 ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `books_issued`
--
ALTER TABLE `books_issued`
 ADD KEY `fk_bookid` (`bookid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username1` (`username1`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
 ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books_issued`
--
ALTER TABLE `books_issued`
ADD CONSTRAINT `books_issued_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `books` (`bookid`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
ADD CONSTRAINT `members_ibfk_1` FOREIGN KEY (`id`) REFERENCES `books` (`bookid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
