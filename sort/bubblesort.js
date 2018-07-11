//冒泡排序
// 时间复杂度  O(n2) O(n2) O(n)
// 空间复杂度   O（1） 不稳定
var arr = [1,80,9,13,57,254,23,34,3,30]
function bubble(arr) {
    var len = arr.length
    for(let i = 0;i<len-1;i++) {
        for(let j =0;j<len-1-i;j++) {
            if(arr[j]>arr[j+1]) {
                [arr[j],arr[j+1]] = [arr[j+1],arr[j]]
            }
        }
    }
    return arr
}
console.log(bubble(arr))

