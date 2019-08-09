def maxScore = _score * 2;

def praiseMax = maxScore * 0.045;
def browseMax = maxScore * 0.015;
def collectMax = maxScore * 0.075;
def refMax = maxScore * 0.045;
def downloadMax = maxScore * 0.015;
def commentMax = maxScore * 0.03;
def maxScores = [praiseMax, browseMax, collectMax, refMax, downloadMax, commentMax];

def praiseTimes = doc['praiseTimes'].value;
def browseTimes = doc['browseTimes'].value;
def collectTimes = doc['collectTimes'].value;
def refTimes= doc['refTimes'].value;
def downloadTimes = doc['downloadTimes'].value;
def childCommentQuantity = doc['childCommentQuantity'].value;
def originScores = [praiseTimes, browseTimes, collectTimes, refTimes, downloadTimes, childCommentQuantity];

for (int i = 0; i < 6; i++) {
    if (originScores[i] == 0){originScores[i] = 1}
    originScores[i] = Math.log(originScores[i]);
    if (originScores[i] > maxScores[i]){originScores[i] = maxScores[i]}
}

def expertMax = maxScore * 0.075;
def flagExpert = doc['flagExpert'].value;
def expertScore = 0;
if (flagExpert == 1){expertScore = expertMax}

def attentionUserMax = maxScore * 0.086;
def attentionUserScore = 0;

def attentionZoneMax = maxScore * 0.086;
def updateMax = maxScore * 0.028;

def finalScore = _score;
for (int i = 0; i < originScores.size(); i++) {
    finalScore += originScores[i];
}
return finalScore


