<template>
<div>
    <h1>Сотрудники предприятия <span style="color: #8074D6">«DT»</span></h1>
    <div class="MainGrid mt-4">

        <div>
            <v-card outlined style="height: 100%; border-radius: 10px; border-color:#E4EBF6;">
                <v-container>
                    <v-row class="mr-2 ml-2">
                        <h4>Все сотрудники</h4>
                        <v-spacer></v-spacer>
                        <v-btn small text class="mt-1 mr-2" style="color: #95AAC9">
                            <v-icon left>
                            </v-icon>Сортировка
                        </v-btn>
                        <v-btn small text class="mt-1" style="color: #95AAC9">
                            <v-icon left>
                            </v-icon>Фильтр
                        </v-btn>
                    </v-row>
                    <v-row class="mt-8 mx-2">
                        <v-col cols="5">
                            <h6 style="color: #6E84A3">ФИО</h6>
                        </v-col>
                        <v-spacer></v-spacer>
                        <v-col cols="5">
                            <h6 style="color: #6E84A3">Статус</h6>
                        </v-col>
                        <v-spacer></v-spacer>
                        <v-col cols="2">
                            <h6 style="color: #6E84A3">Состояние</h6>
                        </v-col>
                    </v-row>
                    <v-divider class="mt-1"></v-divider>

                    <div v-for="worker in workers" v-bind:key="worker.id">
                        <!-- <router-link :to="{name: 'userid', params: {id: worker.id, workerInfo: workerInfo }}" style="text-decoration: none; color: #252733"> -->
                        <div class="card" @click="goTodetail(worker.id, worker.url)" style="border-color: white; height: 6rem; margin-top: -15px">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-1" style="display: flex; justify-content: center; align-items: center;">
                                        <v-avatar size="56">
                                            <img alt="" src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg">
                                        </v-avatar>
                                    </div>
                                    <div class="col-4">
                                        <h6 class="ml-2 mt-2">
                                            <v-list-item-title>
                                                <h6>{{worker.firstName}} {{worker.lastName}}</h6>
                                                <v-list-item-subtitle style="color: #95AAC9">{{worker.specialty}}</v-list-item-subtitle>
                                            </v-list-item-title>
                                        </h6>
                                    </div>
                                    <div class="col-5 mt-2">
                                        <v-list-item-title>
                                            <h6 v-if="worker.status">Работает</h6>
                                            <h6 v-if="!worker.status">Не работает</h6>
                                        </v-list-item-title>
                                        <v-list-item-subtitle style="color: #95AAC9">На работе уже /час. /мин.</v-list-item-subtitle>
                                    </div>
                                    <div class="col-2 mt-2">
                                        <div v-for="health in worker.health" v-bind:key="health.id">

                                            <v-chip dark color="#29CC97" v-if="health.state === 1">
                                                <p class="mt-4">Здоров</p>
                                            </v-chip>
                                            <v-chip dark color="#FEC400" v-if="health.state === 2">
                                                <p class="mt-4">Подоз.</p>
                                            </v-chip>
                                            <v-chip dark color="#F12B2C" v-if="health.state === 3">
                                                <p class="mt-4">Критич.</p>
                                            </v-chip>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- </router-link> -->

                        <v-divider></v-divider>
                    </div>


                </v-container>
            </v-card>
        </div>
        <div>
            <router-view></router-view>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            renderComponent: true,
            infoWorker: null,
            workers: null,
            config: {
                method: 'get',
                url: 'https://api.dt-prod.ru/workers/',
                headers: {
                    Authorization: null
                }
            },
            series: [{
                name: 'series1',
                data: [1, 3, 3]
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
            },],
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
        };

    },
    methods: {

        updateChart(sex, pizda) {
            const newDataSeries = sex
            const newDataLabels = pizda
            // In the same way, update the series option
            this.series = [{
                data: newDataSeries
            }]
            this.chartOptions.xaxis = [{
                categories: newDataLabels
            }]
        },
        Sex(aaa) {
            // console.log('SSSS')
            let i = 0;

            // var is = [];
            // console.log(response.data.watchdogWeek[0])
            for (var key in aaa.data.watchdogWeek) {




                var startTime = aaa.data.watchdogWeek[key].checkIn;
                var endTime = aaa.data.watchdogWeek[key].checkOut;

                var s = startTime.split(':');
                var e = endTime.split(':');

                var end = new Date(0, 0, 0, parseInt(e[1], 10), parseInt(e[0], 10), 0);
                var start = new Date(0, 0, 0, parseInt(s[1], 10), parseInt(s[0], 10), 0);

                var elapsedMs = end - start;
                var elapsedMinutes = elapsedMs / 1000 / 60;

                this.series[0].data[i] = elapsedMinutes;
                this.chartOptions.xaxis.categories[i] = aaa.data.watchdogWeek[key].date
                i++;
                // this.updateChart(this.series[0].data, this.chartOptions.xaxis.categories)
                // console.log(endTime)
            }
            // this.updateChart(this.series[0].data, this.chartOptions.xaxis.categories)
            // console.log(this.series1)
        },
        Sex1(aaa) {
            let b = 0;
            for (var key1 in aaa.data.pulse) {

                var pulseMin = aaa.data.pulse[key1].pulseMin;
                var pulseMax = aaa.data.pulse[key1].pulseMax;


                this.series1[0].data[b] = pulseMax;
                this.series1[1].data[b] = pulseMin
                this.chartOptions1.xaxis.categories[b] = aaa.data.pulse[key1].date

                // this.updateChart(this.series[0].data, this.chartOptions.xaxis.categories)
                // console.log(this.series1[1].data[b])
                // console.log(this.series1[1].data[b])
                // console.log(this.series1[1].data[b])
                b++;
            }
            console.log(this.series1[1].data)
        },

        goTodetail(id, url) {
            this.config.url = url;
            // console.log(this.series)
            axios(this.config)
                .then(response => {
                    this.Sex(response)
                    this.Sex1(response)
                    this.$router.push({

                        name: 'userid',
                        params: {
                            id: id,
                            url: url,
                            info: response.data,
                            series: this.series,
                            chartOptions: this.chartOptions,
                            series1: this.series1,
                            chartOptions1: this.chartOptions1,
                        }
                    })
                },);
        },
        ButtonToUser(url) {
            localStorage.url = url;
            this.config.url = url;
            axios(this.config)
                .then(response => (this.infoWorker = response.data));
            return (this.infoWorker)
        },
    },
    mounted() {
        axios(this.config)
            .then(response => (this.workers = response.data));
        // console.log(this.workers)

    }
}
</script>
<style>
.MainGrid {
    display: grid;
    grid-template-columns: 4fr 5fr;
    grid-gap: 4%;
}
</style>
