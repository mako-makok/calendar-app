<template>
  <v-menu
    ref="menu"
    v-model="menu"
    :close-on-content-click="false"
    transition="scale-transition"
    offset-y
    min-width="290px"
  >
    <template v-slot:activator="{ on }">
      <v-text-field
        class="date-text-field"
        v-model="formatedDate"
        @blur="date = parseDate(dateFormated)"
        readonly
        v-on="on"
      />
    </template>
    <v-date-picker
      v-model="date"
      no-title
      scrollable
      locale="jp-ja"
      :day-format="date => new Date(date).getDate()"
      @input="menu = false"
    />
  </v-menu>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'

@Component
export default class FormDatePiicker extends Vue {
  @Prop({ required: true })
  private propDate!: number[]
  private date = this.propDate
  private menu = false

  private formatDate(date: string) {
    if (!date) return null

    const [year, month, day] = date.split('-')
    return `${year}年${month}月${day}日`
  }

  private parseDate(date: string) {
    if (!date) return null

    const year = date.substring(0, 4)
    const month = date.substring(5, 7)
    const day = date.substring(8, 10)
    return `${year}-${month}-${day}`
  }

  private get formatedDate() {
    return this.formatDate(this.propDate.join('-'))
  }
}
</script>

<style lang="scss">
.date-text-field {
  font-size: 80%;
}
</style>
