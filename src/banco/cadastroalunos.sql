-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 11-Dez-2018 às 16:33
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cadastroalunos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `id` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `idade` int(11) NOT NULL,
  `npai` varchar(300) NOT NULL,
  `nmae` varchar(300) NOT NULL,
  `cidade` varchar(300) NOT NULL,
  `rua` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `id` int(11) NOT NULL,
  `disciplina` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplinas`
--

INSERT INTO `disciplinas` (`id`, `disciplina`) VALUES
(1, 'Português'),
(2, 'Matemática'),
(3, 'Química'),
(4, 'Física'),
(5, 'Biologia'),
(6, 'História'),
(7, 'Geografia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `login` varchar(200) NOT NULL,
  `senha` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `login`, `senha`) VALUES
(1, 'Administrador', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `notas`
--

CREATE TABLE `notas` (
  `id` int(11) NOT NULL,
  `idAluno` int(11) NOT NULL,
  `idDisciplina` int(11) NOT NULL,
  `NomeAluno` varchar(255) NOT NULL,
  `nota` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Indexes for table `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idAluno` (`idAluno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `notas`
--
ALTER TABLE `notas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`idAluno`) REFERENCES `alunos` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
