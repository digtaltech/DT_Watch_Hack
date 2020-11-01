<template>
<div class="GridOnUserId mr-6" v-if="3 === 3">
    <div>
        <v-card outlined style="height: 100%; border-radius: 10px; border-color:#E4EBF6;">
            <v-row class="mr-2 ml-5 my-5">
                <h5>Профиль</h5>
            </v-row>
            <v-divider></v-divider>
            <div class="card mb-3" style="border-color: white; margin-top: -1rem">
                <div class="card-body">
                    <div style="text-align: center">
                        <img src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg" class="" style="height: 90px; width: 90px; border-radius: 100%; margin-bottom: 10px">
                        <h5 class="card-title mb-5">{{this.$route.params.info.firstName}} {{this.$route.params.info.lastName}}</h5>
                        <v-row style="margin-bottom: -1rem">
                            <p>Специальность</p>
                            <v-spacer></v-spacer>
                            <p style="color: #95AAC9">{{this.$route.params.info.specialty}}</p>
                        </v-row>
                        <v-divider></v-divider>
                        <v-row style="margin-bottom: -1rem">
                            <p>Локация</p>
                            <v-spacer></v-spacer>
                            <p style="color: #95AAC9">Мостурбаза</p>
                        </v-row>
                        <v-divider></v-divider>
                        <v-row style="margin-bottom: -1rem">
                            <p>Компания</p>
                            <v-spacer></v-spacer>
                            <p style="color: #95AAC9">DT</p>
                        </v-row>
                        <v-divider></v-divider>
                    </div>
                    <v-row>
                        <p class="mt-1" style="color: #95AAC9">Работает</p>
                        <v-spacer></v-spacer>
                        <div class="btn btn-sm" style="background-color: #8074D6; height: 31px">
                            <p style="color: #ffffff">Изменить</p>
                        </div>
                    </v-row>
                </div>
            </div>
        </v-card>
    </div>
    <div>
        <v-card outlined style="height: 100%; border-radius: 10px; border-color:#E4EBF6;">
            <v-row class="mr-2 ml-5 my-5">
                <h5>Времени на объекте</h5>
                <v-spacer></v-spacer>

                <v-btn small text class=" mr-2" style="color: #95AAC9">
                    <v-icon left>
                    </v-icon>Неделя
                </v-btn>
                <v-btn small text style="color: #95AAC9">
                    <v-icon left>
                    </v-icon>Месяц
                </v-btn>
            </v-row>
            <v-divider></v-divider>
            <div class="chart-wrap">
                <div id="chart">
                    <apexchart type="area" height="350" :options="chartOptions" :series="series"></apexchart>
                </div>

            </div>
        </v-card>
    </div>
    <div>
        <v-card outlined style="height: 100%; border-radius: 10px; border-color:#E4EBF6;">
            <v-row class="mr-2 ml-5 my-5">
                <h5>Пульс за неделю</h5>
                <v-spacer></v-spacer>
                <div class="custom-control custom-switch">
                    <input type="checkbox" class="custom-control-input" id="customSwitches">
                    <label class="custom-control-label" for="customSwitches">За день</label>
                </div>
            </v-row>
            <v-divider></v-divider>
            <div id="chart1">
                <apexchart type="bar" height="250" :options="chartOptions1" :series="series1"></apexchart>
            </div>
        </v-card>
    </div>
    <div>
        <v-card outlined style="height: 100%; border-radius: 10px; border-color:#E4EBF6;">
            <v-row class="mr-2 ml-5 my-5">
                <h5>Пульс</h5>
            </v-row>
            <v-divider></v-divider>
            <div class="card-body" v-for="health in this.$route.params.info.health" v-bind:key="health.id">
                <v-row style="margin-bottom: -1rem">
                    <p>Последнее измерение</p>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">{{health.pulseLast}}</p>
                </v-row>
                <v-divider></v-divider>
                <v-row style="margin-bottom: -1rem">
                    <p>Минимальный</p>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">{{health.pulseMin}}</p>
                </v-row>
                <v-divider></v-divider>
                <v-row style="margin-bottom: -1rem">
                    <p>Максимальный</p>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">{{health.pulseMax}}</p>
                </v-row>
                <v-divider></v-divider>
            </div>
        </v-card>
    </div>
</div>
</template>
<script>
import VueApexCharts from 'vue-apexcharts'

export default {
    components: {
        apexchart: VueApexCharts,
    },
    data() {
        return {

            UserUrl: null,
            worker: null,
            watchdogWeek: null,
            config: {
                method: 'get',
                url: this.$route.params.url,
                headers: {
                    Authorization: null
                }
            },
            series: [{
                name: 'series1',
                data: []
            }, ],
            chartOptions: {
                chart: {
                    height: 350,
                    type: 'area'
                },
                colors: ['#8074D6'],
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    curve: 'smooth'
                },
                xaxis: {
                    type: 'datetime',
                    categories: ["2018-09-19", "2018-09-20", "2018-09-21", "2018-09-22", "2018-09-23", "2018-09-24", "2018-09-25"]
                },
                tooltip: {
                    x: {
                        format: 'dd/MM/yy HH:mm'
                    },
                },
            },
            series1: [{
                name: 'Максимальный',
                data: [44, 55, 41, 67, 22, 43]
            }, {
                name: 'Минимальный',
                data: [13, 23, 20, 8, 13, 27]
            }, ],
            chartOptions1: {
                colors: ['#8074D6', '#29CC97'],
                chart: {
                    type: 'bar',
                    height: 350,
                    stacked: true,
                    toolbar: {
                        show: true
                    },
                    zoom: {
                        enabled: true
                    }
                },
                responsive: [{
                    breakpoint: 480,
                    options: {
                        legend: {
                            position: 'bottom',
                            offsetX: -10,
                            offsetY: 0
                        }
                    }
                }],
                plotOptions: {
                    bar: {
                        horizontal: false,
                    },
                },
                xaxis: {
                    type: 'datetime',
                    categories: ['01/01/2011 GMT', '01/02/2011 GMT', '01/03/2011 GMT', '01/04/2011 GMT',
                        '01/05/2011 GMT', '01/06/2011 GMT'
                    ],
                },
                legend: {
                    position: 'right',
                    offsetY: 40
                },
                fill: {
                    opacity: 1
                }
            },


        }
    },
    methods: {
        updateChart(series, labels) {
            const newDataSeries = series
            const newDataLabels = labels
            // In the same way, update the series option
            this.series = [{
                data: newDataSeries
            }]
            this.chartOptions.xaxis = [{
                categories: newDataLabels
            }]
        },
        updateChart1(series1, labels1, series2) {
            const newDataSeries1 = series1
            const newDataSeries2 = series2
            const newDataLabels1 = labels1
            // In the same way, update the series option
            // alert(newDataSeries1)
            this.series1 = [{
                    data: newDataSeries1
                },
                {
                    data: newDataSeries2
                }
            ]
            this.chartOptions1.xaxis = [{
                categories: newDataLabels1
            }]
        },

    },
    mounted() {
        this.updateChart(this.$route.params.series[0].data, this.$route.params.chartOptions.xaxis.categories)
        this.updateChart1(this.$route.params.series1[0].data, this.$route.params.chartOptions1.xaxis.categories, this.$route.params.series1[1].data)
    },
    computed: {
        id() {
            return this.$route.params.series;

        },
        ids() {
            return this.$route.params.chartOptions;

        },
        xx() {
            return this.$route.params.series1;

        },
        zz() {
            return this.$route.params.chartOptions1;

        },
        url() {
            return this.$route.params.url;
        }
    },
    watch: {
        '$route.params.series': function() {
            // this.Fuck()
            this.config.url = this.$route.params.url
            this.updateChart(this.$route.params.series[0].data, this.$route.params.chartOptions.xaxis.categories)
            this.updateChart1(this.$route.params.series1[0].data, this.$route.params.chartOptions1.xaxis.categories, this.$route.params.series1[1].data)
            // this.Data();
            // alert(this.config.url)
        }
    }

};
</script>
<style>
.GridOnUserId {
    display: grid;
    grid-template-columns: 3fr 2fr 3fr;
    grid-gap: 10px;
}

.GridOnUserId div:nth-child(1) {
    grid-column: 1 / 2;
}

.GridOnUserId div:nth-child(2) {
    grid-column: 2 / 4;
}

.GridOnUserId div:nth-child(3) {
    grid-column: 1 / 3;
}

.GridOnUserId div:nth-child(4) {
    grid-column: 3 / 4;
}
</style>
