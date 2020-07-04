<template>
  <v-card>
    <v-container>
      <v-form>
        <v-row no-gutters>
          <v-col />
          <v-col :cols="11">
            <v-text-field placeholder="タイトルと日時を追加" />
          </v-col>
        </v-row>
        <v-row justify="end" dense>
          <v-col align-self="center" :cols="1">
            <v-icon>
              schedule
            </v-icon>
          </v-col>
          <v-col>
            <FormDatePicher :propDate="date" />
          </v-col>
          <v-col v-if="useTime" :cols="2">
            <v-combobox v-model="startTime" :items="times" />
          </v-col>
          <v-col :cols="1" align-self="center" style="text-align: center;">
            <div class="hyphen-to">
              <p>-</p>
            </div>
          </v-col>
          <v-col v-if="useTime" :cols="2">
            <v-combobox v-model="endTime" :items="times" />
          </v-col>
          <v-col>
            <FormDatePicher :propDate="date" />
          </v-col>
          <v-col v-if="!useTime" :cols="3" align-self="center">
            <v-btn small text outlined width="80%" @click="useTime = true">
              時間を追加
            </v-btn>
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-col :cols="1" align-self="center">
            <v-icon>
              subject
            </v-icon>
          </v-col>
          <v-col :cols="11">
            <v-text-field placeholder="説明を追加" />
          </v-col>
        </v-row>
        <v-row align="end" dense>
          <v-col :cols="9" />
          <v-col :cols="3">
            <v-btn color="primary" width="80%" @click="clickedRegister">
              保存
            </v-btn>
          </v-col>
        </v-row>
      </v-form>
    </v-container>
  </v-card>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator'
import FormDatePicher from '@/components/Calendar/AddSchedule/FormDatePicher.vue'

@Component({
  components: {
    FormDatePicher
  }
})
export default class FormSchedule extends Vue {
  @Prop() date!: number[]
  @Prop({ default: '' }) title!: string
  @Prop({ default: '' }) description!: string
  private useTime = false
  private times = [...Array(96).keys()].map(
    i => `${('00' + Math.floor((i + 1) / 4)).slice(-2)}:${('00' + (((i + 1) * 15) % 60)).slice(-2)}`
  )

  @Emit()
  private clickedRegister() {
    this.useTime = false
  }
}
</script>

<style lang="scss">
.hyphen-to {
  font-size: 150%;
}
</style>
