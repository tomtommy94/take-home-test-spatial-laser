'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {dfwViews: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/dfwViews?size=1000'}).done(response => {
			this.setState({dfwViews: response.entity._embedded.dfwViews});
		});
	}

	render() { // <3>
		return (
			<DfwList dfwViews={this.state.dfwViews.filter(dfwView => dfwView.withinBuffer === true)}/>
		)
	}
}
// end::app[]

// tag::dfw-list[]
class DfwList extends React.Component{
	render() {
		const data = this.props.dfwViews;
		
		const dfwDemoes = data.map(dfwView =>
			<DfwView key={dfwView._links.self.href} dfwView={dfwView}/>
		);
		const avgIncome = (data.reduce(
			(income, dfwView) => income = income + dfwView.income, 0)
		)/data.length;
		const totalPop = data.reduce(
			(pop, dfwView) => pop = pop + dfwView.population, 0);
		return (
			<table>
				<tbody>
					<tr>
						<th>Average Income</th>
						<th>Total Population</th>
					</tr>
					<tr>
						<td>${parseFloat(avgIncome).toFixed(2)}</td>
						<td>{totalPop}</td>
					</tr>
				</tbody>
			</table>
		)
	}
}
// end::dfw-list[]

// tag::dfwDemo[]
class DfwView extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.dfwView.income}</td>
				<td>{this.props.dfwView.population}</td>
			</tr>
		)
	}
}
// end::dfwDemo[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
