'use strict';

const React = require('react')
const ReactDOM = require('react-dom')
const rest = require('rest')
const mime = require('rest/interceptor/mime')
const errorCode = require('rest/interceptor/errorCode')
const client = rest.wrap(mime).wrap(errorCode);


const cityChangedListeners = []
const fireCityChangeEvent = (city) => cityChangedListeners.forEach(listener => listener(city))


class App extends React.Component {

    render() {
        return (
            <WeatherTable />
        )
    }
}

class WeatherTable extends React.Component {

    constructor(props) {
        super(props)
        cityChangedListeners.push(this.cityChangedListener.bind(this))
        this.state = {weather: null}
    }

    cityChangedListener(city) {
        client({path: `/weather/${city}`}).then(response => this.setState({weather: response.entity}))
    }

    render() {
        const time = this.state.weather != null ? this.state.weather.updateTime : "";
        const weather = this.state.weather != null ? this.state.weather.weather : "";
        const temp = this.state.weather != null ? `${(this.state.weather.temperature - 273.15).toFixed(2)} °C` : "";
        const wind = this.state.weather != null ? `${this.state.weather.wind} m/s` : "";
        return (
            <div className="divTable">
                <div className="divTableBody">
                    <div className="divTableRow">
                        <div className="divTableCell">City</div>
                        <div className="divTableCell"><CitySelection /></div>
                    </div>
                    <div className="divTableRow">
                        <div className="divTableCell">Updated time</div>
                        <div className="divTableCell">{time}</div>
                    </div>
                    <div className="divTableRow">
                        <div className="divTableCell">Weather</div>
                        <div className="divTableCell">{weather}</div>
                    </div>
                    <div className="divTableRow">
                        <div className="divTableCell">Temperature</div>
                        <div className="divTableCell">{temp}</div>
                    </div>
                    <div className="divTableRow">
                        <div className="divTableCell">Wind</div>
                        <div className="divTableCell">{wind}</div>
                    </div>
                </div>
            </div>
        )
    }
}

class CitySelection extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            cities: []
        }
    }

    componentDidMount() {
        client({path: '/city/getcities'}).then(response =>
            this.setState({cities: response.entity.map(e => e.name)}, fireCityChangeEvent(response.entity[0].name)))
    }

    citySelected(e) {
        fireCityChangeEvent(e.target.value)
    }

    render() {
        return (
            <select onChange={this.citySelected}>
                {this.state.cities.map(city => (<option value={city}>{city}</option>))}
            </select>
        )
    }
}

ReactDOM.render(<App />, document.getElementById('react'))

