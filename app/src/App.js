import React from 'react';
import { BrowserRouter as Switch, Route } from 'react-router-dom';
import './App.css';
import { CadastrarQuestaoScreen } from './tela/index';
import { Header } from './component/index'

function App() {
	return (
		<div className="principal">
			<Header/>
			<Switch>
				<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
			</Switch>
		</div>
	);
}

export default App;
