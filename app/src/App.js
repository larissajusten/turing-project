import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { Header } from './component';
import './App.css';
import { CadastroMultiplaQuestao } from './tela';

function App() {
	return (
		<div className="principal">
			<CadastroMultiplaQuestao />
		</div>
	);
}

export default App;
