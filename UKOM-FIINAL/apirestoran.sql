-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2021 at 09:46 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apirestoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `iddetail` int(10) UNSIGNED NOT NULL,
  `idorder` int(11) NOT NULL,
  `idmenu` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `hargajual` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`iddetail`, `idorder`, `idmenu`, `jumlah`, `hargajual`, `created_at`, `updated_at`) VALUES
(1, 1, 10, 1, 5000, '2021-03-20 17:46:42', '2021-03-20 17:46:42'),
(2, 1, 15, 2, 20000, '2021-03-20 17:46:42', '2021-03-20 17:46:42'),
(3, 4, 14, 2, 20000, NULL, NULL),
(4, 4, 15, 4, 40000, NULL, NULL),
(5, 4, 16, 3, 6000, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kategoris`
--

CREATE TABLE `kategoris` (
  `idkategori` int(10) UNSIGNED NOT NULL,
  `kategori` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `keterangan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kategoris`
--

INSERT INTO `kategoris` (`idkategori`, `kategori`, `keterangan`, `created_at`, `updated_at`) VALUES
(110, 'Makanan ringan', 'Makanan ringan', '2021-03-04 19:20:44', '2021-03-25 15:44:49'),
(111, 'Minuman', 'Minuman', '2021-03-04 19:21:15', '2021-03-04 19:21:15'),
(119, 'Gorengan', 'Gorengan', '2021-03-05 05:32:14', '2021-03-05 05:32:14'),
(122, 'Buah', 'Buah', '2021-03-11 10:11:38', '2021-03-11 10:11:38'),
(125, 'Adat', 'Toko Adat', NULL, NULL),
(126, 'Profesi', 'Toko Profesi', NULL, NULL),
(127, 'Badat', 'Baju Adat', NULL, NULL),
(128, 'Bprofesi', 'Baju Profesi', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `idmenu` int(10) UNSIGNED NOT NULL,
  `idkategori` bigint(20) NOT NULL,
  `menu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ntoko` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ntokop` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nbajuadat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nbajuprofesi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jam` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jamp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamatp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kota` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kotap` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kondisi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kondisip` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `deskripsibj` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `deskripsibjp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fotobj` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fotobjp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gambar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `harga` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hargabj` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hargabjp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`idmenu`, `idkategori`, `menu`, `ntoko`, `ntokop`, `nbajuadat`, `nbajuprofesi`, `jam`, `jamp`, `alamat`, `alamatp`, `kota`, `kotap`, `kondisi`, `kondisip`, `deskripsibj`, `deskripsibjp`, `fotobj`, `fotobjp`, `gambar`, `harga`, `hargabj`, `hargabjp`, `created_at`, `updated_at`) VALUES
(9, 111, 'Es Jeruk', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/es jeruk.jpg', '5000', '', '', '2021-03-09 14:49:01', '2021-03-12 07:02:53'),
(10, 111, 'Es Teh', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/es teh.jpeg', '5000', '', '', '2021-03-09 14:49:13', '2021-03-09 14:49:13'),
(13, 110, 'Nasi', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/nasi.jpg', '5000', '', '', '2021-03-11 05:39:51', '2021-03-11 05:39:51'),
(14, 110, 'Bakso', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/bakso.jpg', '10000', '', '', '2021-03-11 05:40:10', '2021-03-11 05:40:10'),
(15, 110, 'Bakso Keju', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/baksokeju.jpg', '10000', '', '', '2021-03-11 10:10:44', '2021-03-11 10:10:44'),
(16, 122, 'Apel', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/apel.jpg', '2000', '', '', '2021-03-11 10:12:35', '2021-03-12 07:15:41'),
(17, 122, 'Pisang', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/pisang.jpg', '2000', '', '', '2021-03-11 10:16:15', '2021-03-11 10:16:15'),
(19, 110, 'Sate', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/sate.jpg', '10000', '', '', '2021-03-12 07:20:59', '2021-03-12 07:20:59'),
(20, 111, 'Es Jeruk Pisang', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'http://localhost:8000/upload/esjerukpisang.jpg', '5000', '', '', '2021-03-12 07:21:37', '2021-03-12 07:21:37'),
(21, 125, '', 'RIRA COLLECTION', '', '', '', '22.00', '', 'Jl. Pelangi Jaya, Anggaswangi,\r\nKec. Sukodono, Kabupaten Sidoarjo,\r\nJawa Timur 61258', '', 'Sidoarjo', '', '', '', '', '', '', '', '', '', '', '', NULL, NULL),
(22, 127, '', '', '', 'Baju Adat Jawa Tengah', '', '', '', '', '', '', '', 'Lengkap', '', 'Baju Adat Jawa Timur Lengkap. Tersedia ukuran S dan L Dilengkapi dengan aksesoris dan sepatu', '', '', '', '', '', '55000', '', NULL, NULL),
(23, 128, '', '', '', '', 'Baju Profesi Koki', '', '', '', '', '', '', '', 'Lengkap (minus sepatu)', 'Baju Profesi Koki.\r\nTersedia ukuran L dan XL Dilengkapi dengan aksesoris', 'Baju Profesi Koki. Tersedia ukuran L dan XL Dilengkapi dengan aksesoris', '', '', '', '', '', '55000', NULL, NULL),
(24, 126, '', '', 'SEWA BAJU MERIAH SEKALII', '', '', '', '23.45', '', 'Prima Berkah Jaya Blok B10/5, Klagen, Wilayut, Kec. Sukodono, Kabupaten Sidoarjo, Jawa Timur 61258', '', 'Sidoarjo', '', '', '', '', '', '', '', '', '', '', NULL, NULL),
(26, 126, '', '', 'BUNGA BUNGA PERSEWAAN BAJU', '', '', '', '2345', 'Gg. Mawar, Sikep, Keboansikep, Kec. Gedangan, Kabupaten Sidoarjo, Jawa Timur 61254', '', '', 'Sidoarjo', '', '', '', '', '', '', '', '', '', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(3, '2021_02_11_175101_create_kategoris_table', 1),
(4, '2021_02_11_190132_create_pelanggans_table', 1),
(5, '2021_02_17_125146_create_menus_table', 2),
(6, '2021_02_18_184428_user', 3),
(7, '2021_02_18_190835_user', 4),
(8, '2021_03_16_174440_create_orders_table', 5),
(9, '2021_03_16_174652_create_details_table', 5),
(10, '2021_11_21_053546_add_jam_to_menus_table', 6),
(11, '2021_11_21_054107_add_alamat_to_menus_table', 7),
(12, '2021_11_21_054351_add_kondisi_to_menus_table', 8),
(13, '2021_11_21_054556_add_deskripsibj_to_menus_table', 9),
(14, '2021_11_21_054743_add_fotobj_to_menus_table', 10),
(15, '2021_11_21_222317_add_kota_to_menus_table', 11),
(16, '2021_11_22_010728_add_ntoko_to_menus_table', 12),
(17, '2021_11_22_014527_add_nbajuadat_to_menus_table', 13),
(18, '2021_11_22_014832_add_hargabj_to_menus_table', 14),
(19, '2021_11_22_015957_add_nbajuprofesi_to_menus_table', 15),
(20, '2021_11_22_020824_add_kondisip_to_menus_table', 16),
(21, '2021_11_22_021055_add_deskripsibjp_to_menus_table', 16),
(22, '2021_11_22_021210_add_fotobjp_to_menus_table', 16),
(23, '2021_11_22_021328_add_hargabjp_to_menus_table', 16),
(24, '2021_11_22_021642_add_ntokop_to_menus_tables', 17),
(25, '2021_11_22_021952_add_jamp_to_menus_table', 18),
(26, '2021_11_22_022111_add_alamatp_to_menus_table', 18),
(27, '2021_11_22_022227_add_kotap_to_menus_table', 18),
(28, '2021_11_23_001202_add_nama_to_users_table', 19),
(29, '2021_11_23_001403_add_alamat_to_users_table', 19),
(30, '2021_11_23_001520_add_telp_to_users_table', 19),
(31, '2021_11_23_001632_add_sandi_to_users_table', 19);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `idorder` int(10) UNSIGNED NOT NULL,
  `idpelanggan` int(11) NOT NULL,
  `tglorder` date NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`idorder`, `idpelanggan`, `tglorder`, `total`, `bayar`, `kembali`, `status`, `created_at`, `updated_at`) VALUES
(1, 2, '2021-03-04', 20000, 50000, 30000, 1, NULL, '2021-03-16 18:09:31'),
(2, 6, '2021-03-08', 20000, 30000, 10000, 1, NULL, '2021-03-17 18:12:35'),
(3, 27, '2021-03-17', 10000, 10000, 0, 1, NULL, '2021-03-17 18:12:57'),
(4, 17, '2021-03-21', 20000, 0, 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggans`
--

CREATE TABLE `pelanggans` (
  `idpelanggan` int(10) UNSIGNED NOT NULL,
  `pelanggan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pelanggans`
--

INSERT INTO `pelanggans` (`idpelanggan`, `pelanggan`, `alamat`, `telp`, `created_at`, `updated_at`) VALUES
(1, 'pelanggan', 'alamat', 'telepon', '2021-02-12 01:19:26', '2021-02-15 15:03:03'),
(2, 'Soobin', 'Surabaya', '08123333', '2021-02-12 01:21:24', '2021-02-12 01:21:24'),
(3, 'Prof. Newell Schmidt Jr.', '10063 Carlo Glen\nNew Earleneland, ND 19080-1307', '312.464.5464', '2021-02-12 01:29:07', '2021-02-12 01:29:07'),
(4, 'Prof. Magdalena Botsford I', '8979 Miller Flat\nNew Taya, WY 76361', '+1.621.591.2272', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(5, 'Prof. Lonny Moore Sr.', '725 Gregorio River Suite 525\nNorth Helmerhaven, CA 67396-1469', '912-276-7661', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(6, 'Nicole Doyle', '6010 Rosalyn Stravenue Suite 402\nPort Garrett, DE 77060-6775', '(343) 245-4626', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(7, 'Cordia Hermiston', '2191 Stoltenberg Crossroad Apt. 344\nWaltermouth, NE 04947', '+1-253-386-7930', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(8, 'Rosella O\'Reilly', '68739 Vincenza Common Suite 261\nChloeton, GA 03715', '1-450-528-2506', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(10, 'Bernie Lockman', '453 Marvin Spring\nEast Verdie, DC 88236-2302', '+1-349-349-1854', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(12, 'update axios export', 'update axios export', '098765', '2021-02-12 01:32:24', '2021-02-25 19:45:11'),
(13, 'Prof. Krista King DVM', '6085 Weldon Street\nChristiansenview, AR 11422-6767', '(959) 757-7353', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(14, 'Ivah Oberbrunner', '12227 Lela Landing\nEast Wilmer, NH 50337', '+1.780.900.3613', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(15, 'Maribel Runolfsdottir III', '6670 Kaya Squares Apt. 855\nLake Demario, PA 09898-6812', '+1 (639) 594-0150', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(16, 'Dr. Omer Armstrong DVM', '39656 Predovic Walks Apt. 176\nVanessahaven, DE 30474-1298', '+1 (340) 557-8435', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(17, 'Liliane Dietrich', '8972 White Villages Apt. 211\nWest Janastad, AK 26547-2951', '773.778.8821', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(21, 'Alexis Runte', '7701 Bernhard Pines\nCedrickhaven, GA 13117', '510-360-7487', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(22, 'Prof. Aubree Fay III', '1484 Marvin Isle Apt. 217\nSchroederhaven, MI 64826', '+1-918-878-7927', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(24, 'Lola O\'Kon', '7536 O\'Kon Knoll\nEast Hilario, DC 14479', '+1-750-641-6019', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(25, 'Bria VonRueden', '4789 Bayer Street\nLake Kimshire, MS 47836-5741', '278.268.1355', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(26, 'Queenie Deckow I', '363 Luettgen Bridge Apt. 414\nNew Joanie, VT 61438', '+1 (958) 209-2975', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(27, 'Louisa Schuppe', '4342 Windler Drive\nWest Kendrick, MT 69887', '+1.227.879.1461', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(28, 'Ryan Becker', '6879 Emmet Hill\nNorth Emmitt, SD 46470-0697', '(441) 437-0623', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(30, 'Lilla Nader', '3266 Josiah Pine Suite 479\nDietrichside, ME 90944-1676', '923.255.4603', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(31, 'Miss Esperanza Cassin IV', '43897 Hettinger Point Suite 357\nNorth Sabinaburgh, NE 04193', '+16025019901', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(32, 'Kenneth Robel', '663 Chance Run Suite 282\nBrigitteview, MT 63640', '627.367.4448', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(33, 'Octavia Hills', '7251 Lebsack Lodge\nPort Craigside, KY 79469', '+1 (845) 790-5780', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(34, 'Mr. Sage Moore', '181 Champlin Forks\nDarwinhaven, AK 45681-5044', '1-950-782-8902', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(35, 'Lafayette Schaefer MD', '39329 Blanda Prairie\nWest Jolie, OR 05819-0064', '1-607-581-7779', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(36, 'Yvette Hahn', '26836 Candace Ways Apt. 643\nKellenstad, AK 35058-4918', '+1-718-817-5356', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(37, 'Dr. Evans Robel', '37701 Rau Summit Apt. 170\nPort Virginieburgh, NH 54055-3398', '(494) 938-0942', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(38, 'Prof. Jaren Renner', '162 Iva Port Suite 107\nEast Paristown, NE 02416-5141', '+1 (667) 945-4983', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(39, 'Dr. Salvador Murray', '9610 Feeney Gateway Suite 674\nWest Rico, IA 18218', '+1-696-537-8162', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(40, 'Keith Emard', '2721 Kohler Station Suite 173\nKarahaven, MN 73163-5071', '+16709360625', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(41, 'Caterina Kuhn', '52412 Bertrand Spur Apt. 847\nWest Kamilleberg, NH 81374-5222', '(742) 887-3640', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(42, 'Johnpaul Wiza', '802 Grace Squares\nWest Pinkshire, TN 99540-3214', '+15647418630', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(43, 'Edwin Baumbach', '927 Feest Lakes\nO\'Reillybury, HI 14635-7083', '240.868.1712', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(44, 'Aron Schneider', '866 Damon Shore\nHillchester, CO 75782', '246.412.6468', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(45, 'Jeramie Hane DVM', '779 Dooley Flat Suite 670\nCristbury, ID 73951-4076', '+1-553-369-0679', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(46, 'Gerry Hayes', '6237 Kshlerin Trail\nTylerburgh, KS 95039-5738', '+1-484-930-9120', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(47, 'Cale Crooks', '961 Sauer Forest\nDemetriusmouth, OK 48381', '1-765-297-9350', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(48, 'Elias Hegmann', '727 Parisian Lake Suite 625\nShanestad, MS 79044', '918-658-5632', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(49, 'Jany Langosh', '440 Balistreri Extension Apt. 575\nWest Aiden, AK 76811', '(750) 852-9942', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(50, 'Amanda Casper', '5279 Stoltenberg Summit\nBernierstad, HI 10803-3384', '226.380.8715', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(51, 'Raphael Grant', '490 Orrin Freeway\nPort Schuyler, MA 86122-8846', '1-248-522-5791', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(52, 'Dr. Stanton Smitham Jr.', '1798 Frederick Path\nMelissaberg, NM 63642-8034', '+1-253-479-8514', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(53, 'Ms. Elnora O\'Kon', '2899 Rice Lights Suite 880\nNew Lia, AZ 61852', '280-512-4685', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(54, 'Ettie Purdy', '247 Shanahan Road\nLake Taryn, AK 38435-0262', '1-648-878-3664', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(55, 'Helene Oberbrunner IV', '89668 Veum Cape\nEast Dallin, ID 35868-6224', '790-984-3331', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(56, 'Davin Zulauf', '613 Vivien Burg Apt. 526\nEstevanshire, WA 07974-3048', '(225) 285-1173', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(57, 'Easton Jacobs', '26247 Robel Freeway\nArdithville, DC 46655-8718', '+1.503.919.1599', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(58, 'Taya Hessel', '1098 Ophelia Green Suite 608\nEast Chanceville, WY 35784', '+13047831889', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(59, 'Agustina Wiegand', '70952 Feest Lock\nEast Akeemchester, TX 63169-8942', '469-727-5086', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(60, 'Dr. Brendan Oberbrunner II', '696 Raven Rest Apt. 692\nShaniyafort, NY 87384', '580-438-3597', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(61, 'Billie Purdy', '69050 Mose Underpass Apt. 686\nLake Hannaport, AR 85071-9956', '220-884-5504', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(62, 'Reba Hickle', '2866 Senger Extensions\nStantonland, AL 14685', '+1-663-530-5799', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(63, 'Mr. Neal Bernhard III', '1818 Callie Ports Apt. 186\nEast Nasir, AK 50133-6841', '(982) 420-1230', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(64, 'Emmanuel Hudson DVM', '3107 Cormier Knolls\nSouth Myriamview, OK 48783', '+1-806-451-4301', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(65, 'Cara Hodkiewicz', '300 Jedediah Mall\nSouth Margarett, SC 78232-0562', '+1 (671) 224-4077', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(66, 'Kennith Treutel', '962 Lelia Dam Suite 791\nWest Keegan, NM 86481-7154', '+1-894-371-9138', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(67, 'Laron Pouros', '223 Kub Station Suite 599\nLake Abagailburgh, GA 01832-4824', '+1-249-813-4755', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(68, 'Patrick Watsica', '47579 Bernice Highway Suite 600\nLake Irmamouth, IA 61508-9885', '+1-642-237-3391', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(69, 'Megane Lehner', '67313 Beth Loop Suite 491\nLake Jalyn, MS 86236', '654-878-9051', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(70, 'Horacio Fisher', '6650 Paolo Fields Suite 157\nMayafort, MA 88947-0739', '+16743134962', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(71, 'Eloy Dickens', '1880 Bruen Views\nPort Rachaelfurt, WA 01130', '429.643.2850', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(72, 'Kirsten Lebsack', '614 Emmet Park\nBeierfort, OR 88196-8588', '+1-208-799-4858', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(73, 'Albert Shields', '35580 Abbey Springs\nLake Dominicfurt, KS 48050', '(410) 966-7897', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(74, 'Vida Prohaska', '28605 McGlynn Camp Apt. 443\nSouth Gabriella, WI 99133', '+15329931050', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(75, 'Ms. Brandi Nitzsche', '987 Purdy Villages Apt. 203\nFaychester, SD 24119', '1-819-705-0939', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(76, 'Prof. Kayla Turner', '78802 Gracie Mews\nMarianneton, UT 11877', '+1-996-261-2370', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(77, 'Mr. Koby Wuckert MD', '81237 Pearline Motorway Suite 238\nNew Lelandtown, MO 38297', '946-810-9345', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(78, 'Mrs. Freeda Stamm IV', '40269 Gabriella Lodge Suite 502\nEast Gregfurt, VT 98217-3861', '691-541-5803', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(79, 'Jermey Hills', '428 Jaime Walk Suite 336\nBrekkehaven, TN 67853-5944', '298-228-1764', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(80, 'Jay Pagac', '507 June Summit Apt. 671\nKlockochester, OK 54494-5651', '252-520-9595', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(81, 'Prof. Holly Littel DVM', '2758 Gideon Valley\nEast Kaia, MS 26746-0132', '687-732-6798', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(82, 'Maida Stark', '90669 Rosenbaum Coves Suite 303\nSouth Kenyonfort, FL 58790-8567', '681.709.9530', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(83, 'Prof. Ford Lind MD', '9545 Magali Garden Apt. 200\nNienowside, OH 13128', '+1-917-829-1097', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(84, 'Prof. Garnet Veum DVM', '29111 Prosacco Spurs\nWest Victor, IL 26406', '843.648.8942', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(85, 'Eladio Moore', '9329 Veum Gardens\nDangelofurt, MN 34723', '(531) 362-7873', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(86, 'Regan Boyer', '7277 Jerde Ville\nWest Neil, CT 25047', '+1-879-543-6861', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(87, 'Ms. Cheyenne Walter IV', '64767 Hamill Mountain\nSouth Odellhaven, OR 62476-2355', '+1 (280) 537-2713', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(88, 'Velda Shanahan', '237 Jay Manors Apt. 858\nEast Steveport, LA 42671-3463', '+14208573212', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(89, 'Ellen Tillman', '62462 Hermann Passage\nMonahanchester, KY 61057', '(835) 847-9806', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(90, 'Ms. Lisette Lemke Sr.', '35640 Medhurst Union Suite 923\nNew Alana, CT 78032-8582', '787-297-2431', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(91, 'Ms. Janessa Dooley I', '846 Orpha Gateway\nSouth Markus, KY 30418', '203-378-7028', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(92, 'Grayson Sauer', '1625 Bosco Spur\nLake Annaliseville, MO 63457-2026', '+1.610.679.8911', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(93, 'Joanne Paucek', '4021 Gaylord Trail Suite 281\nEast Diegomouth, VA 06236', '884-949-6048', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(94, 'Mrs. Dixie Pfannerstill', '249 Heller Brook\nClemensview, KY 46946', '+1-402-320-1023', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(95, 'Jackeline McClure', '7230 Fiona Garden Apt. 563\nForreststad, NE 55054', '1-387-440-6125', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(96, 'Dora Hintz', '21997 Alycia Island\nNew Deshawn, MD 24082', '+1-464-612-1574', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(97, 'Florencio Rice', '729 Hollie Avenue\nPort Audrey, WA 77267', '1-587-813-6155', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(98, 'Jaden Hoppe', '9279 Hildegard Islands\nCarlosburgh, MO 98721', '1-919-392-2630', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(99, 'Randall Huels', '7277 Wilfred Ways Suite 609\nLeoneborough, KS 90138', '594-520-2243', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(100, 'Kari Reynolds', '45347 Friesen Mills Suite 375\nEnidville, RI 62331', '443-971-6580', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(101, 'Dr. Alejandrin Metz', '513 Labadie Overpass\nFaheyview, AL 58350', '426-416-1209', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(102, 'Nakia Shanahan', '9025 Yasmin Station\nEast Hillaryville, KS 56600', '740-668-2569', '2021-02-12 01:32:24', '2021-02-12 01:32:24'),
(105, 'pelanggann', 'alamat', '09876544', '2021-02-15 16:03:58', '2021-02-15 16:03:58'),
(108, 'pelanggan axios', 'alamat axios', '09887666', '2021-02-25 17:39:55', '2021-02-25 17:39:55'),
(110, 'Hyuk Jae', 'Malang', '09887654', '2021-02-25 17:45:41', '2021-02-25 17:45:41'),
(111, 'pelanggan axios export', 'alamat axios export', '09887654', '2021-02-25 19:39:46', '2021-02-25 19:39:46');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sandi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `level` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `api_token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `relasi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nama`, `alamat`, `telp`, `sandi`, `email`, `password`, `level`, `api_token`, `status`, `relasi`, `created_at`, `updated_at`) VALUES
(1, '', '', '', '', 'tiwaiten@gmail.com', 'password', 'pelanggan', '0znqaOo30k1cqZ38nVX7BtHQMxDUV2dngH04xhyP', 1, 'tiwaiten@gmail.com', '2021-02-18 19:15:07', '2021-02-18 19:39:18'),
(2, '', '', '', '', 'email@gmail.com', 'password', 'pelanggan', 'yZKoio3IddXBOSuL11xp2FC10211XW5mrobC8EZl', 1, 'email@gmail.com', '2021-02-18 19:24:27', '2021-02-18 19:37:47'),
(10, '', '', '', '', 'sweetdelight@gmail.com', 'password', 'pelanggan', 'aT8j0GagYPADnx8ytd9hNXFrXW2cYsBs1F7PWh5l', 1, 'sweetdelight@gmail.com', NULL, '2021-03-29 05:54:45'),
(11, '', '', '', '', 'admin@gmail.com', '$2y$10$8G/w6jUjN0PPrE3zD8mdkO12KRMih8O9SV7vzDrCM4YinN3nDNEQS', 'admin', 'qJwoQwaRE9d0nitCsccrUN3z7hMuMLvzLRNk0nTt', 1, 'back', '2021-03-29 05:57:46', '2021-03-29 06:32:17'),
(12, '', '', '', '', 'kasir@gmail.com', '$2y$10$4p8GAl8Vv8eaO7Vh06jmPeURCEgStmFe/r/ym8IdIpR/uZyt3gZNO', 'kasir', 'oZkKuqOwdCWorRS8UMtkI3y0wwzEpgoWxzHch7Vl', 1, 'back', '2021-03-29 05:58:47', '2021-03-29 06:29:14'),
(13, '', '', '', '', 'koki@gmail.com', '$2y$10$GE8zxPcTNvoMWSeTSbGbjOr/ZbzF2Usx/wCoyaF1Xm0ZyawtMhzOy', 'koki', 'T3kIYw73V6MLcEO1Dr3XCr3ZB58Jo0vOoSC5vgNj', 1, 'back', '2021-03-29 05:59:26', '2021-03-29 06:29:24'),
(14, '', '', '', '', 'joni@gmail.com', '$2y$10$7k8zXRLJSYY6POqC6Z/VsOQDzMBuy8s4RgjMkjOVHMCOh1eo9W0DO', 'kasir', 'vrn1NXhnaKw9ekkbW3CNJH7y1vsQljQsZKjshofQ', 1, 'back', '2021-03-29 06:31:29', '2021-03-29 06:31:41'),
(15, '', '', '', '', 'sitikusmati@gmail.com', '$2y$10$R9sRaRZhUBxn7er.V42YmeUcMnAhELER/AbDZJHigY6QXMoG0XE2K', 'koki', 'SIddbPttUwolAt594ksGH3lO0wG0pW8eVCHfWBok', 1, 'back', '2021-03-29 06:32:42', '2021-03-29 06:32:50'),
(16, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 00:26:17', '2021-11-23 00:26:17'),
(17, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:19:34', '2021-11-23 01:19:34'),
(18, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:21:00', '2021-11-23 01:21:00'),
(19, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:21:03', '2021-11-23 01:21:03'),
(20, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:22:46', '2021-11-23 01:22:46'),
(21, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:23:06', '2021-11-23 01:23:06'),
(22, 'Karina', 'Jalan Bunga Indah', '0812345678910', 'karina123', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:29:38', '2021-11-23 01:29:38'),
(23, 'y', 'y', 'y', 'y', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:31:08', '2021-11-23 01:31:08'),
(24, 'h', 'h', 'h', 'h', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 01:45:51', '2021-11-23 01:45:51'),
(25, 'Karina', 'Jalan Indah', '081', 'aa', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:07:54', '2021-11-23 03:07:54'),
(26, 'a', 'a', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:09:37', '2021-11-23 03:09:37'),
(27, 'b', 's', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:10:35', '2021-11-23 03:10:35'),
(28, 'c', 'd', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:12:49', '2021-11-23 03:12:49'),
(29, 'x', 'w', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:13:31', '2021-11-23 03:13:31'),
(30, 'a', 'w', '1', '2', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:14:14', '2021-11-23 03:14:14'),
(31, 'a', '1', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:18:05', '2021-11-23 03:18:05'),
(32, 'a', '1', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:19:02', '2021-11-23 03:19:02'),
(33, 'a', '1', '1', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 03:20:07', '2021-11-23 03:20:07'),
(34, 'b', 'jdsbj', 'jsd', 'b', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:05:41', '2021-11-23 04:05:41'),
(35, 'a', 'a', '11', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:06:45', '2021-11-23 04:06:45'),
(36, 'c', 'c', 'c', 'c', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:07:54', '2021-11-23 04:07:54'),
(37, 'a', 'a', 'a', 'a', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:08:52', '2021-11-23 04:08:52'),
(38, 'b', 'b', 'b', 'b', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:21:34', '2021-11-23 04:21:34'),
(39, 'i', 'i', 'i', 'i', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:24:35', '2021-11-23 04:24:35'),
(40, 'z', 'z', 'z', 'z', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:35:04', '2021-11-23 04:35:04'),
(41, 'm', 'm', '1111111111111', 'm', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 04:48:09', '2021-11-23 04:48:09'),
(42, 'l', 'l', 'l', 'l', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 05:58:18', '2021-11-23 05:58:18'),
(43, 'r', 'r', 'r', 'r', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:03:02', '2021-11-23 06:03:02'),
(44, 'y', 'Jalan Bunga Indah', '0812345678910', 'y', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:20:35', '2021-11-23 06:20:35'),
(45, 'a', 'a', '11', '1111111111', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:20:56', '2021-11-23 06:20:56'),
(46, 'k', 'k', 'k', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:21:49', '2021-11-23 06:21:49'),
(47, 'k', 'k', 'k', 'k', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:22:20', '2021-11-23 06:22:20'),
(48, 'b', 'b', 'b', '1111111111', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:23:15', '2021-11-23 06:23:15'),
(49, 'q', 'q', 'q', '1', 'uwu', 'uwu', 'uwu', 'uwu', 1, 'uwu', '2021-11-23 06:26:38', '2021-11-23 06:26:38');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`iddetail`);

--
-- Indexes for table `kategoris`
--
ALTER TABLE `kategoris`
  ADD PRIMARY KEY (`idkategori`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`idmenu`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`idorder`);

--
-- Indexes for table `pelanggans`
--
ALTER TABLE `pelanggans`
  ADD PRIMARY KEY (`idpelanggan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `iddetail` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kategoris`
--
ALTER TABLE `kategoris`
  MODIFY `idkategori` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `idmenu` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `idorder` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pelanggans`
--
ALTER TABLE `pelanggans`
  MODIFY `idpelanggan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
