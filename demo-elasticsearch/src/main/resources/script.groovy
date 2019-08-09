def maxScore = _score * 2;
def praiseMax = maxScore * 0.045;
def praiseTimes = doc['praiseTimes'].value;
if (praiseTimes == 0){
    praiseTimes = 1;
}
def praiseScore =Math.log(praiseTimes);
if (praiseScore > praiseMax) {praiseScore = praiseMax}
def browseMax = maxScore * 0.015;
def browseScore = Math.log(doc['browseTimes'].value);
if (browseScore > browseMax) {browseScore = browseMax}
def collectMax = maxScore * 0.075;
def collectScore = Math.log(doc['collectTimes'].value);
if (collectScore > collectMax) {collectScore = collectMax}
def expertMax = maxScore * 0.075;
def expertScore = 0;
if (doc['flagExpert'] == 1){expertScore = expertMax}
def refMax = maxScore * 0.045;
def refScore = Math.log(doc['refTimes'].value);
if (refScore > refMax) {refScore = refMax}

def downloadMax = maxScore * 0.015;
def downloadScore = Math.log(doc['downloadTimes'].value);
if (downloadScore > downloadMax) {downloadScore = downloadMax}
def commentMax = maxScore * 0.03;
def commentScore = Math.log(doc['childCommentQuantity'].value);
if (commentScore > commentMax) {commentScore = commentMax}

def attentionUserMax = maxScore * 0.086;
def attentionUserScore = 0;

def attentionZoneMax = maxScore * 0.086;
def updateMax = maxScore * 0.028;

return _score + praiseScore + browseScore + collectScore + expertScore + refScore + downloadScore + commentScore;


